package br.com.empiricus.auth_email_service.users.adapters.outbound.entity;

import br.com.empiricus.auth_email_service.users.core.domain.User;
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
public class UserEntityTest {

    @Mock
    private User user;

    @InjectMocks
    private UserEntity userEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void emailEntityEmailConstructorTest() {
        userEntity = new UserEntity(user);
        assertNotNull(userEntity);
    }

    @Test
    public void emailEntityToEmailTest() {
        userEntity = new UserEntity(user);
        assertNotNull(userEntity.toUser());
    }
}
