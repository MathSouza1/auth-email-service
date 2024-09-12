package br.com.empiricus.auth_email_service.emails.core.ports.inbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.exceptions.DeleteEmailException;

public interface DeleteEmailPort {

    void execute(Email email) throws DeleteEmailException;
}
