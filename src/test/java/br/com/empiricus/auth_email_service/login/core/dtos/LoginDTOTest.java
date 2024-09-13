package br.com.empiricus.auth_email_service.login.core.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class LoginDTOTest {

    @InjectMocks
    private LoginDTO login;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterAndGetterTest() {
        login.setCpf("1");
        login.setPassword("1");
        login.getCpf();
        login.getPassword();
        assertNotNull(login);
    }

    @Test
    void allArgsConstructorTest() {
        login = new LoginDTO("1", "1");
        assertNotNull(login);
    }

    @Test
    void noArgsConstructorTest() {
        login = new LoginDTO();
        assertNotNull(login);
    }
}