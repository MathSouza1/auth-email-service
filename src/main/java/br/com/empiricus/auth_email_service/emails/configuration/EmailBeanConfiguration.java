package br.com.empiricus.auth_email_service.emails.configuration;

import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.services.FindEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailBeanConfiguration {

    @Bean
    public FindEmailService findEmailService(FindEmailRepositoryPort findEmailRepository) {
        return new FindEmailService(findEmailRepository);
    }
}
