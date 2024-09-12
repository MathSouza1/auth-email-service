package br.com.empiricus.auth_email_service.users.core.ports.inbound;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;

import java.util.List;

public interface FindUserPort {

    User findByCpf(String cpf) throws UserNotFoundException;

    List<User> findAll();
}
