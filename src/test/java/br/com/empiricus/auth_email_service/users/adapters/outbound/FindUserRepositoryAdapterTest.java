package br.com.empiricus.auth_email_service.users.adapters.outbound;

import br.com.empiricus.auth_email_service.users.adapters.outbound.entity.UserEntity;
import br.com.empiricus.auth_email_service.users.adapters.outbound.repository.UserRepository;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
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
public class FindUserRepositoryAdapterTest {

    @Autowired
    private Optional<UserEntity> userEntity;

    @Mock
    private UserRepository repository;

    @InjectMocks
    private FindUserRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findEmailByIdFailTest() {
        assertThrows(UserNotFoundException.class, () -> adapter.findByCpf("12345678901"));
    }

    @Test
    void findEmailByEhAdminIsTrueTest() {
        assertDoesNotThrow(() -> adapter.findAll());
    }
}

