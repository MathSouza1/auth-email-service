package br.com.empiricus.auth_email_service.emails.core.ports.inbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;

public interface SaveEmailPort {

    Email execute(CreateEmailDTO createEmailDTO) throws UserNotFoundException;
}
