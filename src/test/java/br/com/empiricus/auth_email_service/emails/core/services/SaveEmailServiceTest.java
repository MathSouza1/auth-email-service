package br.com.empiricus.auth_email_service.emails.core.services;


import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SaveEmailException;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.FindEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SaveEmailRepositoryPort;
import br.com.empiricus.auth_email_service.emails.core.ports.outbound.SendEmailRepositoryPort;
import br.com.empiricus.auth_email_service.users.core.ports.outbound.FindUserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SaveEmailServiceTest {

    @Mock
    private SaveEmailRepositoryPort saveEmail;
    @Mock
    private SendEmailRepositoryPort sendEmail;
    @Mock
    private FindUserRepositoryPort findUser;
    @Mock
    private FindEmailRepositoryPort findEmail;

    @InjectMocks
    private SaveEmailService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveEmailFailTest() {
        assertThrows(SaveEmailException.class, () -> service.execute(new CreateEmailDTO()));
    }
}
