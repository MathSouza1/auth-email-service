package br.com.empiricus.auth_email_service.users.core.domain;

import br.com.empiricus.auth_email_service.users.adapters.outbound.entity.UserEntity;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private UpdateUserDTO updateUserDTO;

    @Mock
    private UserEntity userEntity;

    @InjectMocks
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterTest() {
        user.setCpf("1");
        user.setName("1");
        user.setPassword("1");
        user.setCreationDate("1");
        user.setUpdateDate("1");
        user.setAdmin(true);
        assertNotNull(user);
    }

    @Test
    void noArgsConstructorTest() {
        assertNotNull(user);
    }

    @Test
    void updateDTOConstructorTest() {
        user = new User(updateUserDTO);
        assertNotNull(user);
    }

    @Test
    void userEntityConstructorTest() {
        user = new User(userEntity);
        assertNotNull(user);
    }
}
