package br.com.empiricus.auth_email_service.emails.core.ports.inbound;

import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.EmailNotFoundException;

import java.util.List;

public interface FindEmailPort {

    List<EmailsListDTO> findEmailByCpf(String cpf) throws EmailNotFoundException;
}
