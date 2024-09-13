package br.com.empiricus.auth_email_service.users.core.services;

import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class FindUserServiceTest {

    @Mock
    private FindUserRepositoryPort findUser;

    @InjectMocks
    private FindUserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findUserByCpfTest() {
        assertDoesNotThrow(() -> service.findByCpf("1"));
    }

    @Test
    void findAllTest() {
        assertDoesNotThrow(() -> service.findAll());
    }
}
