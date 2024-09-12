package br.com.empiricus.auth_email_service.emails.adapter.inbound;

import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.FindEmailPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final FindEmailPort findEmail;

    public EmailController(FindEmailPort findEmail) {
        this.findEmail = findEmail;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<EmailsListDTO>> findEmailByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(findEmail.findEmailByCpf(cpf), HttpStatus.OK);
    }
}
