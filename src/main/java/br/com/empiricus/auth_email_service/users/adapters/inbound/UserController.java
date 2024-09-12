package br.com.empiricus.auth_email_service.users.adapters.inbound;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.dtos.CreateUserDTO;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.DeleteUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.SaveUserPort;
import jakarta.validation.Valid;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    private final FindUserPort findUser;
    private final SaveUserPort saveUser;
    private final DeleteUserPort deleteUser;

    public UserController(FindUserPort findUser, SaveUserPort saveUser, DeleteUserPort deleteUser) {
        this.findUser = findUser;
        this.saveUser = saveUser;
        this.deleteUser = deleteUser;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<User> findUserByCpf(@PathVariable String cpf) throws UserNotFoundException {
        return new ResponseEntity<>(findUser.findByCpf(cpf), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(findUser.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(saveUser.create(createUserDTO), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO) throws UserNotFoundException {
        User user = findUserByCpf(updateUserDTO.getCpf()).getBody();
        if (Objects.nonNull(user)) {
            updateUserDTO.setCreationDate(user.getCreationDate());
            return new ResponseEntity<>(saveUser.update(updateUserDTO), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deleteUser(@PathVariable String cpf) throws UserNotFoundException {
        if(findUserByCpf(cpf).getStatusCode().is2xxSuccessful()) {
            deleteUser.execute(cpf);
            return new ResponseEntity<>("User with the CPF: " + cpf + " deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("User with the CPF: " + cpf + " does NOT exists.", HttpStatus.NOT_FOUND);
    }
}
