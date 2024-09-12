package br.com.empiricus.auth_email_service.emails.adapters.outbound.repository;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailRepository extends JpaRepository<EmailEntity, String> {

    List<EmailEntity> findEmailByCpf(String cpf);

    Optional<EmailEntity> findEmailById(String id);
}
