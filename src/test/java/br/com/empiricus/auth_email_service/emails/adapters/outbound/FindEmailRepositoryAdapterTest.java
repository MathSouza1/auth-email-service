package br.com.empiricus.auth_email_service.emails.adapters.outbound;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.entity.EmailEntity;
import br.com.empiricus.auth_email_service.emails.adapters.outbound.repository.EmailRepository;
import br.com.empiricus.auth_email_service.emails.core.exceptions.EmailNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FindEmailRepositoryAdapterTest {

    @Autowired
    private Optional<EmailEntity> emailEntity;

    @Mock
    private EmailRepository repository;

    @InjectMocks
    private FindEmailRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findEmailByCpfTest() {
        assertDoesNotThrow(() -> adapter.findEmailByCpf("123456"));
    }

    @Test
    void findEmailByIdFailTest() {
        assertThrows(EmailNotFoundException.class, () -> adapter.findEmailById("1"));
    }

    @Test
    void findEmailByEhAdminIsTrueTest() {
        assertDoesNotThrow(() -> adapter.findEmailByEhAdminIsTrue());
    }
}