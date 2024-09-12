package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;

import java.util.List;

public class FindUserService implements FindUserPort {

    private final FindUserRepositoryPort findUser;

    public FindUserService(FindUserRepositoryPort findUser) {
        this.findUser = findUser;
    }

    @Override
    public User findByCpf(String cpf) throws UserNotFoundException {
        return findUser.findByCpf(cpf);
    }

    @Override
    public List<User> findAll() {
        return findUser.findAll();
    }
}
