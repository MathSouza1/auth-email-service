package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SaveEmailRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.dtos.CreateUserDTO;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SaveUserServiceTest {

    @Mock
    private SaveEmailRepositoryPort saveUser;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private CreateUserDTO userDTO;

    @Mock
    private UpdateUserDTO updateUserDTO;

    @InjectMocks
    private SaveUserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserFailTest() {
        assertThrows(NullPointerException.class, () -> service.create(userDTO));
    }

    @Test
    void updateUserFailTest() {
        assertThrows(NullPointerException.class, () -> service.update(updateUserDTO));
    }
}
