package br.com.empiricus.auth_email_service.users.adapters.outbound;

import br.com.empiricus.auth_email_service.users.adapters.outbound.repository.UserRepository;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.DeleteUserRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class DeleteUserRepositoryAdapter implements DeleteUserRepositoryPort {

    private final UserRepository userRepository;

    public DeleteUserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(String cpf) {
        userRepository.deleteByCpf(cpf);
    }
}
