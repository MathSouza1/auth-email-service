package br.com.empiricus.auth_email_service.emails.adapters.outbound;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.services.EmailProducer;
import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class SendEmailAdapterTest {

    @Mock
    private EmailProducer repository;

    @Mock
    private Email email;

    @InjectMocks
    private SendEmailAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendEmailTest() {
        assertDoesNotThrow(() -> adapter.execute(email, new ArrayList<>(), "ok"));
    }
}
