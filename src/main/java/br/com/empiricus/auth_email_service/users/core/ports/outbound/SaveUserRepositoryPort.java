package br.com.empiricus.auth_email_service.users.core.ports.outbound;

import br.com.empiricus.auth_email_service.users.core.domain.User;

public interface SaveUserRepositoryPort {

    User execute (User user);
}
