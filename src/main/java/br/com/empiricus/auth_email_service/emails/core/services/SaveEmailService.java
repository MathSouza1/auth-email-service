package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.dtos.SendEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.SaveEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SaveEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SendEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SaveEmailException;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;

import java.util.List;

public class SaveEmailService implements SaveEmailPort {

    private final SaveEmailRepositoryPort saveEmail;
    private final SendEmailRepositoryPort sendEmail;
    private final FindUserRepositoryPort findUser;
    private final FindEmailRepositoryPort findEmail;

    public SaveEmailService(SaveEmailRepositoryPort saveEmail, SendEmailRepositoryPort sendEmail, FindUserRepositoryPort findUser, FindEmailRepositoryPort findEmail) {
        this.saveEmail = saveEmail;
        this.sendEmail = sendEmail;
        this.findUser = findUser;
        this.findEmail = findEmail;
    }

    @Override
    public Email execute(CreateEmailDTO createEmailDTO) throws UserNotFoundException, SaveEmailException {
        try {
            createEmailDTO.setAdmin(findUser.findByCpf(createEmailDTO.getCpf()).getAdmin());
            List<SendEmailDTO> emails = findEmail.findEmailByEhAdminIsTrue();
            if (emails.stream().findFirst().isPresent()) {
                Email email = saveEmail.execute(new Email(createEmailDTO));
                sendEmail.execute(email, emails, "criado");
                return email;
            }
            throw new SaveEmailException("You must have at least one admin user to send the email");
        } catch (Exception e) {
            throw new SaveEmailException(e.getLocalizedMessage());
        }
    }
}
