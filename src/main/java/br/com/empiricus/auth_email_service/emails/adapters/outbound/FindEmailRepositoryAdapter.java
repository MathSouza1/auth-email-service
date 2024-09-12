package br.com.empiricus.auth_email_service.emails.adapters.outbound;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.entity.EmailEntity;
import br.com.empiricus.auth_email_service.emails.adapters.outbound.repository.EmailRepository;
import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindEmailRepositoryAdapter implements FindEmailRepositoryPort {

    private final EmailRepository emailRepository;

    public FindEmailRepositoryAdapter(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public List<EmailsListDTO> findEmailByCpf(String cpf) {
        List<EmailEntity> emails = emailRepository.findEmailByCpf(cpf);
        return emails.stream().map(EmailsListDTO::new).collect(Collectors.toList());
    }
}
