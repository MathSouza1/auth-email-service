package br.com.empiricus.auth_email_service.emails.core.dtos;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.entity.EmailEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class EmailsListDTOTest {

    @Mock
    private EmailEntity entity;

    @InjectMocks
    private EmailsListDTO email;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterAndGetterTest() {
        email.setEmail("1");
        email.setId("1");
        email.getEmail();
        email.getId();
        assertNotNull(email);
    }

    @Test
    void allArgsConstructorTest() {
        email = new EmailsListDTO("1", "1");
        assertNotNull(email);
    }

    @Test
    void emailEntityArgsConstructorTest() {
        email = new EmailsListDTO(new EmailEntity());
        assertNotNull(email);
    }

    @Test
    void noArgsConstructorTest() {
        email = new EmailsListDTO();
        assertNotNull(email);
    }
}
