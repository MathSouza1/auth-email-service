package br.com.empiricus.auth_email_service.users.adapters.outbound;

import br.com.empiricus.auth_email_service.users.adapters.outbound.entity.UserEntity;
import br.com.empiricus.auth_email_service.users.adapters.outbound.repository.UserRepository;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FindUserRepositoryAdapter implements FindUserRepositoryPort {

    private final UserRepository userRepository;

    public FindUserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByCpf(String cpf) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByCpf(cpf);
        if (userEntity.isPresent())
            return userEntity.get().toUser();
        throw new UserNotFoundException("User with the CPF: " + cpf + " does NOT exists.");
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(User::new).collect(Collectors.toList());
    }
}
