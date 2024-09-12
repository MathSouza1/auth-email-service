package br.com.empiricus.auth_email_service.emails.core.ports.outbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.SendEmailDTO;

import java.util.List;

public interface SendEmailRepositoryPort {
    void execute(Email changedEmail, List<SendEmailDTO> emails, String message) throws Exception;
}
