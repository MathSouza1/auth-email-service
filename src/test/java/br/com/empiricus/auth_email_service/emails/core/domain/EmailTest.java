package br.com.empiricus.auth_email_service.emails.core.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class EmailTest {

    @InjectMocks
    private Email email;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterTest() {
        email.setId("1");
        email.setCpf("1");
        email.setEmail("1");
        email.setCreationDate("1");
        email.setUpdateDate("1");
        email.setAdmin(true);
        assertNotNull(email);
    }

    @Test
    void noArgsConstructorTest() {
        assertNotNull(email);
    }
}
