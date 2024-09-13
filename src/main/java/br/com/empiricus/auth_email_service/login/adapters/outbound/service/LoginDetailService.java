package br.com.empiricus.auth_email_service.login.adapters.outbound.service;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginDetailService implements UserDetailsService {

    private final FindUserPort findUser;

    public LoginDetailService(FindUserPort findUser) {
        this.findUser = findUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = findUser.findByCpf(username);
            return new org.springframework.security.core.userdetails.User(user.getCpf(), user.getPassword(), new ArrayList<>());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
