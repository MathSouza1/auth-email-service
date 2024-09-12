package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.dtos.CreateUserDTO;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.SaveUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.SaveUserRepositoryPort;

public class SaveUserService implements SaveUserPort {

    private final SaveUserRepositoryPort saveUser;

    public SaveUserService(SaveUserRepositoryPort saveUser) {
        this.saveUser = saveUser;
    }

    @Override
    public User create(CreateUserDTO createUserDTO) {
        return saveUser.execute(new User(createUserDTO));
    }

    @Override
    public User update(UpdateUserDTO updateUserDTO) {
        return saveUser.execute(new User(updateUserDTO));
    }
}
