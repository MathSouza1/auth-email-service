package br.com.empiricus.auth_email_service.emails.core.ports.outbound;

import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;

import java.util.List;

public interface FindEmailRepositoryPort {

    List<EmailsListDTO> findEmailByCpf(String cpf);
}
