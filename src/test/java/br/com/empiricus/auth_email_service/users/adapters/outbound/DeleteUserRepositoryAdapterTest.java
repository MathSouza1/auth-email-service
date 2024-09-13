package br.com.empiricus.auth_email_service.users.adapters.outbound;

import br.com.empiricus.auth_email_service.users.adapters.outbound.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class DeleteUserRepositoryAdapterTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private DeleteUserRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteByCpfTest() {
        assertDoesNotThrow(() -> adapter.execute("12345678901"));
    }
}