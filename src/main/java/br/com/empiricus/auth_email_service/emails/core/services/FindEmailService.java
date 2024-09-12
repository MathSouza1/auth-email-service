package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.FindEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;

import java.util.List;

public class FindEmailService implements FindEmailPort {

    private final FindEmailRepositoryPort findEmail;

    public FindEmailService(FindEmailRepositoryPort findEmail) {
        this.findEmail = findEmail;
    }

    @Override
    public List<EmailsListDTO> findEmailByCpf(String cpf) {
        return findEmail.findEmailByCpf(cpf);
    }
}
