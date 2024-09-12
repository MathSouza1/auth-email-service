package br.com.empiricus.auth_email_service.users.configuration;

import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.SaveUserRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.services.FindUserService;
import br.com.empiricus.auth_email_service.users.core.services.SaveUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public FindUserService findUserService(FindUserRepositoryPort findUserRepository) {
        return new FindUserService(findUserRepository);
    }

    @Bean
    public SaveUserService saveUserService(SaveUserRepositoryPort saveUserRepository) {
        return new SaveUserService(saveUserRepository);
    }
}
