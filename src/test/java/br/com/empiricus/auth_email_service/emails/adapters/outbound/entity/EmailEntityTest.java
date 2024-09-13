package br.com.empiricus.auth_email_service.emails.adapters.outbound.entity;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class EmailEntityTest {

    @Mock
    private Email email;

    @InjectMocks
    private EmailEntity emailEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void emailConstructorTest() {
        emailEntity = new EmailEntity(email);
        assertNotNull(emailEntity);
    }

    @Test
    public void toEmailTest() {
        emailEntity = new EmailEntity(email);
        assertNotNull(emailEntity.toEmail());
    }
}
