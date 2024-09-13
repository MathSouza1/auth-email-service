package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.dtos.CreateUserDTO;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.SaveUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.SaveUserRepositoryPort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SaveUserService implements SaveUserPort {

    private final SaveUserRepositoryPort saveUser;
    private final PasswordEncoder passwordEncoder;

    public SaveUserService(SaveUserRepositoryPort saveUser, PasswordEncoder passwordEncoder) {
        this.saveUser = saveUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(CreateUserDTO createUserDTO) {
        createUserDTO.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        return saveUser.execute(new User(createUserDTO));
    }

    @Override
    public User update(UpdateUserDTO updateUserDTO) {
        return saveUser.execute(new User(updateUserDTO));
    }
}
