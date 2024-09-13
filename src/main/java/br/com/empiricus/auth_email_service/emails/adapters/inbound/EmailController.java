package br.com.empiricus.auth_email_service.emails.adapters.inbound;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.dtos.EmailsListDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.DeleteEmailException;
import br.com.empiricus.auth_email_service.emails.core.exceptions.EmailNotFoundException;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SaveEmailException;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.DeleteEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.FindEmailPort;
import br.com.empiricus.auth_email_service.emails.core.ports.inbound.SaveEmailPort;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private FindEmailPort findEmail;

    @Autowired
    private SaveEmailPort saveEmail;

    @Autowired
    private DeleteEmailPort deleteEmail;

    @GetMapping("/{cpf}")
    public ResponseEntity<List<EmailsListDTO>> findEmailByCpf(@PathVariable String cpf) throws EmailNotFoundException {
        return new ResponseEntity<>(findEmail.findEmailByCpf(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody CreateEmailDTO createEmailDTO) throws UserNotFoundException, SaveEmailException {
        return new ResponseEntity<>(saveEmail.execute(createEmailDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmail(@PathVariable String id) throws EmailNotFoundException, DeleteEmailException {
        Email email = findEmail.findEmailById(id);
        if (!Objects.isNull(email)) {
            deleteEmail.execute(email);
            return new ResponseEntity<>("Email with the ID: " + id + " deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Email with the ID: " + id + " does NOT exists.", HttpStatus.NOT_FOUND);
    }
}
