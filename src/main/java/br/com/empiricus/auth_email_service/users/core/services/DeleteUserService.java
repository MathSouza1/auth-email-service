package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.users.core.ports.inbound.DeleteUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.DeleteUserRepositoryPort;

public class DeleteUserService implements DeleteUserPort {

    private final DeleteUserRepositoryPort deleteUser;

    public DeleteUserService(DeleteUserRepositoryPort deleteUser) {
        this.deleteUser = deleteUser;
    }

    @Override
    public void execute(String cpf) {
        deleteUser.execute(cpf);
    }
}
