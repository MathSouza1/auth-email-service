package br.com.empiricus.auth_email_service.emails.adapters.outbound;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.services.EmailProducer;
import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.SendEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SendEmailException;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SendEmailRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SendEmailAdapter implements SendEmailRepositoryPort {

    private final EmailProducer emailProducer;

    public SendEmailAdapter(EmailProducer emailProducer) {
        this.emailProducer = emailProducer;
    }

    @Override
    public void execute(Email changedEmail, List<SendEmailDTO> emails, String message) throws SendEmailException {
        emailProducer.sendMessage(changedEmail, emails, message);
    }
}
