package br.com.empiricus.auth_email_service.exceptions;

import br.com.empiricus.auth_email_service.emails.core.exceptions.EmailNotFoundException;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SaveEmailException;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SendEmailException;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ServiceExceptionHandlerTest {

    @Mock
    private UserNotFoundException userNotFoundException;

    @Mock
    private EmailNotFoundException emailNotFoundException;

    @Mock
    private DataIntegrityViolationException dataIntegrityViolationException;

    @Mock
    private ConstraintViolationException constraintViolationException;

    @Mock
    private SendEmailException sendEmailException;

    @Mock
    private SaveEmailException saveEmailException;

    @InjectMocks
    private ServiceExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void userNotFoundHandlerTest() {
        exceptionHandler.userNotFoundHandler(userNotFoundException);
        assertNotNull(exceptionHandler);
    }

    @Test
    void emailsNotFoundHandlerTest() {
        exceptionHandler.emailsNotFoundHandler(emailNotFoundException);
        assertNotNull(exceptionHandler);
    }

    @Test
    void unUniqueFieldHandlerTest() {
        assertThrows(NullPointerException.class, () -> exceptionHandler.unUniqueFieldHandler(dataIntegrityViolationException));
    }

    @Test
    void unformedFieldHandlerTest() {
        exceptionHandler.unformedFieldHandler(constraintViolationException);
        assertNotNull(exceptionHandler);
    }

    @Test
    void cannotSendEmailHandlerTest() {
        exceptionHandler.cannotSendEmailHandler(sendEmailException);
        assertNotNull(exceptionHandler);
    }

    @Test
    void cannotSaveEmailHandlerTest() {
        exceptionHandler.cannotSaveEmailHandler(saveEmailException);
        assertNotNull(exceptionHandler);
    }
}
