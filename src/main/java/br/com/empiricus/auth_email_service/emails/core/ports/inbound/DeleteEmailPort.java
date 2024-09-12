package br.com.empiricus.auth_email_service.emails.core.ports.inbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;

public interface DeleteEmailPort {

    void execute(Email email);
}
