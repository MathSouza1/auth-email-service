package br.com.empiricus.auth_email_service.users.adapters.outbound;

import br.com.empiricus.auth_email_service.users.adapters.outbound.repository.UserRepository;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SaveUserRepositoryAdapterTest {

    @Mock
    private UserRepository repository;

    @Mock
    private User user;

    @InjectMocks
    private SaveUserRepositoryAdapter adapter;

    @Test
    void saveEmailTest() {
        user = new User("1", "name", "12345678901", "password", "teste@teste", "00:00", true);
        assertThrows(NullPointerException.class, () -> adapter.execute(user));
    }
}
