package br.com.empiricus.auth_email_service.login.core.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class GenerateTokenExceptionTest {

    @InjectMocks
    private GenerateTokenException exception;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void noArgsConstructorTest() {
        exception = new GenerateTokenException();
        assertNotNull(exception);
    }

    @Test
    void allArgsConstructorTest() {
        exception = new GenerateTokenException("exception");
        assertNotNull(exception);
    }
}
