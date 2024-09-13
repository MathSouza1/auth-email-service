package br.com.empiricus.auth_email_service.emails.configuration;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.services.EmailProducer;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.DeleteEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SaveEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SendEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.services.DeleteEmailService;
import br.com.empiricus.auth_email_service.emails.core.services.FindEmailService;
import br.com.empiricus.auth_email_service.emails.core.services.SaveEmailService;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailBeanConfiguration {

    @Bean
    public EmailProducer emailProducer() {
        return new EmailProducer();
    }

    @Bean
    public FindEmailService findEmailService(FindEmailRepositoryPort findEmailRepository) {
        return new FindEmailService(findEmailRepository);
    }

    @Bean
    public SaveEmailService saveEmailService(SaveEmailRepositoryPort saveEmailRepository, SendEmailRepositoryPort sendEmailRepositoryPort, FindUserRepositoryPort findUserRepositoryPort, FindEmailRepositoryPort findEmailRepositoryPort) {
        return new SaveEmailService(saveEmailRepository, sendEmailRepositoryPort, findUserRepositoryPort, findEmailRepositoryPort);
    }

    @Bean
    public DeleteEmailService deleteEmailService(DeleteEmailRepositoryPort deleteEmailRepository, SendEmailRepositoryPort sendEmailRepositoryPort, FindEmailRepositoryPort findEmailRepositoryPort) {
        return new DeleteEmailService(deleteEmailRepository, sendEmailRepositoryPort, findEmailRepositoryPort);
    }
}
