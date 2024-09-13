package br.com.empiricus.auth_email_service.emails.core.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CreateEmailDTOTest {

    @InjectMocks
    private CreateEmailDTO email;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterAndGetterTest() {
        email.setId("1");
        email.setCpf("1");
        email.setEmail("1");
        email.setAdmin(true);
        email.getId();
        email.getCpf();
        email.getEmail();
        email.isAdmin();
        assertNotNull(email);
    }

    @Test
    void allArgsConstructorTest() {
        email = new CreateEmailDTO("1", "1", "1", true);
        assertNotNull(email);
    }

    @Test
    void noArgsConstructorTest() {
        assertNotNull(email);
    }
}
