package br.com.empiricus.auth_email_service.login.configuration;

import br.com.empiricus.auth_email_service.login.core.service.LoginService;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class LoginBeanConfiguration {

    @Bean
    public SecurityFilter securityFilter(LoginService loginService, FindUserPort findUserPort) {
        return new SecurityFilter(loginService, findUserPort);
    }

    @Bean
    public LoginService loginService() {
        return new LoginService();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/v3/api-docs/**");
    }
}
