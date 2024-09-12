package br.com.empiricus.auth_email_service.emails.adapter.outbound.repository;

import br.com.empiricus.auth_email_service.emails.adapter.outbound.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<EmailEntity, String> {

    List<EmailEntity> findEmailByCpf(String cpf);
}
