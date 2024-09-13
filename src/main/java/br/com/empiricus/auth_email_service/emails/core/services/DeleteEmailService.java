package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.SendEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.DeleteEmailException;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.DeleteEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.DeleteEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SendEmailRepositoryPort;

import java.util.List;

public class DeleteEmailService implements DeleteEmailPort {

    private final DeleteEmailRepositoryPort deleteEmail;
    private final SendEmailRepositoryPort sendEmail;
    private final FindEmailRepositoryPort findEmail;

    public DeleteEmailService(DeleteEmailRepositoryPort deleteEmail, SendEmailRepositoryPort sendEmailRepository, FindEmailRepositoryPort findEmailRepository) {
        this.deleteEmail = deleteEmail;
        this.sendEmail = sendEmailRepository;
        this.findEmail = findEmailRepository;
    }

    @Override
    public void execute(Email email) throws DeleteEmailException {
        try {
            List<SendEmailDTO> emails = findEmail.findEmailByEhAdminIsTrue();
            if (emails.stream().findFirst().isEmpty())
                throw new DeleteEmailException("You must have at least one admin user to send the email");
            deleteEmail.deleteById(email.getId());
            sendEmail.execute(email, emails, "alterado");
        } catch (Exception e) {
            throw new DeleteEmailException(e.getLocalizedMessage());
        }
    }
}
