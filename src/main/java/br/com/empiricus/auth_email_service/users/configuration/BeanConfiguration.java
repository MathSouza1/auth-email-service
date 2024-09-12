package br.com.empiricus.auth_email_service.users.configuration;

import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.service.FindUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public FindUserService findUserService(FindUserRepositoryPort findUserRepository) {
        return new FindUserService(findUserRepository);
    }
}
