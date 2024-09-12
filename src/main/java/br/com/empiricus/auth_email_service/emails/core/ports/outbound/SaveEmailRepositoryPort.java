package br.com.empiricus.auth_email_service.emails.core.ports.outbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;

public interface SaveEmailRepositoryPort {

    Email execute(Email email);
}
