package br.com.empiricus.auth_email_service.emails.adapters.outbound;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.repository.EmailRepository;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.DeleteEmailRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmailRepositoryAdapter implements DeleteEmailRepositoryPort {

    private final EmailRepository emailRepository;

    public DeleteEmailRepositoryAdapter(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void deleteById(String id) {
        emailRepository.deleteById(id);
    }
}
