package br.com.empiricus.auth_email_service.users.configuration;

import br.com.empiricus.auth_email_service.users.core.ports.outbound.DeleteUserRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.SaveUserRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.services.DeleteUserService;
import br.com.empiricus.auth_email_service.users.core.services.FindUserService;
import br.com.empiricus.auth_email_service.users.core.services.SaveUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserBeanConfiguration {

    @Bean
    public FindUserService findUserService(FindUserRepositoryPort findUserRepository) {
        return new FindUserService(findUserRepository);
    }

    @Bean
    public SaveUserService saveUserService(SaveUserRepositoryPort saveUserRepository, PasswordEncoder passwordEncoder) {
        return new SaveUserService(saveUserRepository, passwordEncoder);
    }

    @Bean
    public DeleteUserService deleteUserService(DeleteUserRepositoryPort deleteUserRepository) {
        return new DeleteUserService(deleteUserRepository);
    }
}
