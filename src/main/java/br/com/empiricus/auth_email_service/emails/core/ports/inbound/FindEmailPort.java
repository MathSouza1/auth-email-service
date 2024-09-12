package br.com.empiricus.auth_email_service.emails.core.ports.inbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;

import java.util.List;

public interface FindEmailPort {

    List<EmailsListDTO> findEmailByCpf(String cpf);
}
