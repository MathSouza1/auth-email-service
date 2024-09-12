package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.DeleteEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.DeleteEmailRepositoryPort;

public class DeleteEmailService implements DeleteEmailPort {

    private final DeleteEmailRepositoryPort deleteEmail;

    public DeleteEmailService(DeleteEmailRepositoryPort deleteEmail) {
        this.deleteEmail = deleteEmail;
    }

    @Override
    public void execute(Email email) {
        deleteEmail.deleteById(email.getId());
    }
}
