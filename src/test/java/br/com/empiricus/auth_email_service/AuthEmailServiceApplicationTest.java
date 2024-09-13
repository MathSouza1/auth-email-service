package br.com.empiricus.auth_email_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AuthEmailServiceApplicationTest {

    @Test
    void authEmailServiceApplicationTest() {
        assertThrows(Exception.class, () -> AuthEmailServiceApplication.main(new String[]{}));
    }
}
