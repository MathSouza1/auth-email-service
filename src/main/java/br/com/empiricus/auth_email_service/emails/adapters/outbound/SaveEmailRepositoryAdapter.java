package br.com.empiricus.auth_email_service.emails.adapters.outbound;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.entity.EmailEntity;
import br.com.empiricus.auth_email_service.emails.adapters.outbound.repository.EmailRepository;
import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SaveEmailRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class SaveEmailRepositoryAdapter implements SaveEmailRepositoryPort {

    private final EmailRepository emailRepository;

    public SaveEmailRepositoryAdapter(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email execute(Email email) {
        return emailRepository.save(new EmailEntity(email)).toEmail();
    }
}
