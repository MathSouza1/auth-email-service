package br.com.empiricus.auth_email_service.users.core.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UpdateUserDTOTest {

    @InjectMocks
    private UpdateUserDTO user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setterAndGetterTest() {
        user.setId("1");
        user.setName("1");
        user.setCpf("1");
        user.setPassword("1");
        user.setCreationDate("1");
        user.setAdmin(true);
        user.getId();
        user.getName();
        user.getCpf();
        user.getPassword();
        user.getCreationDate();
        user.isAdmin();
        assertNotNull(user);
    }

    @Test
    void allArgsConstructorTest() {
        user = new UpdateUserDTO("1", "1", "1", "1", "1", true);
        assertNotNull(user);
    }

    @Test
    void noArgsConstructorTest() {
        assertNotNull(user);
    }
}
