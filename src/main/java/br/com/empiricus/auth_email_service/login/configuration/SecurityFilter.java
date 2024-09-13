package br.com.empiricus.auth_email_service.login.configuration;

import br.com.empiricus.auth_email_service.login.core.service.LoginService;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final LoginService loginService;
    private final FindUserPort findUser;

    public SecurityFilter(LoginService loginService, FindUserPort findUser) {
        this.loginService = loginService;
        this.findUser = findUser;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recoverToken(request);
        String login = loginService.validateToken(token);

        if(Objects.nonNull(login)){
            try {
                User user = findUser.findByCpf(login);
                List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(Objects.isNull(authHeader))
            return null;
        return authHeader.replace("Bearer ", "");
    }
}
