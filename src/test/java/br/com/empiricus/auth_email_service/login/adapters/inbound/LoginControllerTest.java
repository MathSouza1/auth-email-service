package br.com.empiricus.auth_email_service.login.adapters.inbound;

import br.com.empiricus.auth_email_service.login.core.dtos.LoginDTO;
import br.com.empiricus.auth_email_service.login.core.ports.inbound.LoginPort;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    private FindUserPort findUser;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private LoginPort loginPort;

    @Mock
    private LoginDTO loginDTO;

    @Mock
    private User user;

    @InjectMocks
    private LoginController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loginFailBadRequestTest() throws UserNotFoundException {
        assertDoesNotThrow(() -> controller.login(loginDTO));
    }
}

