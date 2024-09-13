package br.com.empiricus.auth_email_service.login.adapters.inbound;

import br.com.empiricus.auth_email_service.login.core.dtos.LoginDTO;
import br.com.empiricus.auth_email_service.login.core.dtos.TokenDTO;
import br.com.empiricus.auth_email_service.login.core.ports.inbound.LoginPort;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final FindUserPort findUser;
    private final PasswordEncoder passwordEncoder;
    private final LoginPort loginPort;

    public LoginController(FindUserPort findUser, PasswordEncoder passwordEncoder, LoginPort loginPort) {
        this.findUser = findUser;
        this.passwordEncoder = passwordEncoder;
        this.loginPort = loginPort;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) throws Exception {
        User user = findUser.findByCpf(loginDTO.getCpf());
        if (Objects.nonNull(user)) {
            if (user.getAdmin()) {
                if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
                    String token = loginPort.generateToken(user);
                    return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}