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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailControllerTest {

    @Mock
    private FindEmailPort findEmail;
    @Mock
    private SaveEmailPort saveEmail;

    @Mock
    private DeleteEmailPort deleteEmail;

    @Mock
    private Email email;

    @Mock
    private CreateEmailDTO emailDTO;

    @Mock
    private List<EmailsListDTO> emailsListDTO;

    @InjectMocks
    private EmailController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmailTest() throws UserNotFoundException, SaveEmailException {
        when(saveEmail.execute(emailDTO)).thenReturn(email);
        assertDoesNotThrow(() -> controller.createEmail(emailDTO));
    }

    @Test
    void findEmailByCpfTest() throws EmailNotFoundException {
        when(findEmail.findEmailByCpf("12345678901")).thenReturn(emailsListDTO);
        assertDoesNotThrow(() -> controller.findEmailByCpf("12345678901"));
    }

    @Test
    void deleteEmailSuccessTest() throws EmailNotFoundException, DeleteEmailException {
        email = new Email(emailDTO);
        when(findEmail.findEmailById("12345678901")).thenReturn(email);
        assertDoesNotThrow(() -> controller.deleteEmail("12345678901"));
    }

    @Test
    void deleteEmailFailTest() throws EmailNotFoundException, DeleteEmailException {
        when(findEmail.findEmailById("12345678901")).thenReturn(null);
        assertDoesNotThrow(() -> controller.deleteEmail("12345678901"));
    }
}
