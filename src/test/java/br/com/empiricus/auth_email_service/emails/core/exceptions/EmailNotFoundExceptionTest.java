package br.com.empiricus.auth_email_service.emails.core.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class EmailNotFoundExceptionTest {

    @InjectMocks
    private EmailNotFoundException exception;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void noArgsConstructorTest() {
        exception = new EmailNotFoundException();
        assertNotNull(exception);
    }

    @Test
    void allArgsConstructorTest() {
        exception = new EmailNotFoundException("exception");
        assertNotNull(exception);
    }
}
