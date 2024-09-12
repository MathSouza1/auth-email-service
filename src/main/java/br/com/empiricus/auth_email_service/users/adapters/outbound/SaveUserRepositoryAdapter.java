package br.com.empiricus.auth_email_service.users.adapters.outbound;

import br.com.empiricus.auth_email_service.users.adapters.outbound.entity.UserEntity;
import br.com.empiricus.auth_email_service.users.adapters.outbound.repository.UserRepository;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.SaveUserRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class SaveUserRepositoryAdapter implements SaveUserRepositoryPort {

    private final UserRepository userRepository;

    public SaveUserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(User user) {
        return userRepository.save(new UserEntity(user)).toUser();
    }
}
