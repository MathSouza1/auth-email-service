package br.com.empiricus.auth_email_service.users.adapters.inbound;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final FindUserPort findUser;

    public UserController(FindUserPort findUser) {
        this.findUser = findUser;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<User> findUserByCpf(@PathVariable String cpf) throws UserNotFoundException {
        return ResponseEntity.ok().body(findUser.findByCpf(cpf));
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok().body(findUser.findAll());
    }
}
