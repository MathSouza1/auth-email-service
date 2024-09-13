package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.DeleteUserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class DeleteUserServiceTest {

    @Mock
    private DeleteUserRepositoryPort deleteUser;

    @Mock
    private User user;

    @InjectMocks
    private DeleteUserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteUserTest() {
        assertDoesNotThrow(() -> service.execute("1"));
    }
}
