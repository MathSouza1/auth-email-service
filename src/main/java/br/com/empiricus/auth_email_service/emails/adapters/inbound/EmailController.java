package br.com.empiricus.auth_email_service.emails.adapters.inbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.FindEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.SaveEmailPort;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final FindEmailPort findEmail;
    private final SaveEmailPort saveEmail;

    public EmailController(FindEmailPort findEmail, SaveEmailPort saveEmail) {
        this.findEmail = findEmail;
        this.saveEmail = saveEmail;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<EmailsListDTO>> findEmailByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(findEmail.findEmailByCpf(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody CreateEmailDTO createEmailDTO) throws UserNotFoundException {
        return new ResponseEntity<>(saveEmail.execute(createEmailDTO), HttpStatus.CREATED);
    }
}
