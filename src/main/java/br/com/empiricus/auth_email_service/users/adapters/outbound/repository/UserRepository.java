package br.com.empiricus.auth_email_service.users.adapters.outbound.repository;

import br.com.empiricus.auth_email_service.users.adapters.outbound.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByCpf(String cpf);
}
