package br.com.empiricus.auth_email_service.login.core.ports.inbound;

import br.com.empiricus.auth_email_service.login.core.exceptions.GenerateTokenException;
import br.com.empiricus.auth_email_service.users.core.domain.User;

public interface LoginPort {

    String generateToken(User user) throws GenerateTokenException;

    String validateToken(String token);
}
