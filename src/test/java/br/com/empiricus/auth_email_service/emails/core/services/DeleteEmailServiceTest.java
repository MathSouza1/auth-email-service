package br.com.empiricus.auth_email_service.emails.core.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.exceptions.DeleteEmailException;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.DeleteEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SendEmailRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DeleteEmailServiceTest {

    @Mock
    private DeleteEmailRepositoryPort deleteEmail;

    @Mock
    private SendEmailRepositoryPort sendEmail;

    @Mock
    private FindEmailRepositoryPort findEmail;

    @Mock
    private Email email;

    @InjectMocks
    private DeleteEmailService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteEmailFailTest() {
        assertThrows(DeleteEmailException.class, () -> service.execute(email));
    }
}
