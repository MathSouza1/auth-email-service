package br.com.empiricus.auth_email_service.login.core.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TokenDTOTest {

    @InjectMocks
    private TokenDTO token;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterAndGetterTest() {
        token.setToken("1");
        token.getToken();
        assertNotNull(token);
    }

    @Test
    void allArgsConstructorTest() {
        token = new TokenDTO("1");
        assertNotNull(token);
    }

    @Test
    void noArgsConstructorTest() {
        token = new TokenDTO();
        assertNotNull(token);
    }
}