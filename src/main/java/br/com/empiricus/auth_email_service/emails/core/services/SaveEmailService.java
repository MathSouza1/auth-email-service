package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.SaveEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SaveEmailRepositoryPort;
import br.com.empiricus.auth_email_service.users.adapters.outbound.FindUserRepositoryAdapter;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;

public class SaveEmailService implements SaveEmailPort {

    private final SaveEmailRepositoryPort saveEmail;
    private final FindUserRepositoryPort findUser;

    public SaveEmailService(SaveEmailRepositoryPort saveEmail, FindUserRepositoryPort findUser) {
        this.saveEmail = saveEmail;
        this.findUser = findUser;
    }

    @Override
    public Email execute(CreateEmailDTO createEmailDTO) throws UserNotFoundException {
        createEmailDTO.setAdmin(findUser.findByCpf(createEmailDTO.getCpf()).getAdmin());
        return saveEmail.execute(new Email(createEmailDTO));
    }
}
