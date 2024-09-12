package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.EmailNotFoundException;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.FindEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;

import java.util.List;

public class FindEmailService implements FindEmailPort {

    private final FindEmailRepositoryPort findEmail;

    public FindEmailService(FindEmailRepositoryPort findEmail) {
        this.findEmail = findEmail;
    }

    @Override
    public List<EmailsListDTO> findEmailByCpf(String cpf) throws EmailNotFoundException {
        List<EmailsListDTO> emails = findEmail.findEmailByCpf(cpf);
        if (emails.stream().findFirst().isEmpty())
            throw new EmailNotFoundException("There is no Emails for the CPF: " + cpf);
        return emails;
    }

    @Override
    public Email findEmailById(String id) throws EmailNotFoundException {
        return findEmail.findEmailById(id);
    }
}
