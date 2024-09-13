package br.com.empiricus.auth_email_service.users.core.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CreateUserDTOTest {

    @InjectMocks
    private CreateUserDTO user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterAndGetterTest() {
        user.setName("1");
        user.setCpf("1");
        user.setPassword("1");
        user.setAdmin(true);
        user.getName();
        user.getCpf();
        user.getPassword();
        user.isAdmin();
        assertNotNull(user);
    }

    @Test
    void allArgsConstructorTest() {
        user = new CreateUserDTO("1", "1", "1", true);
        assertNotNull(user);
    }

    @Test
    void noArgsConstructorTest() {
        assertNotNull(user);
    }
}
