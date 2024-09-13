package br.com.empiricus.auth_email_service.users.adapters.inbound;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.dtos.CreateUserDTO;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;
import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.DeleteUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.SaveUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private FindUserPort findUser;

    @Mock
    private SaveUserPort saveUser;

    @Mock
    private DeleteUserPort deleteUser;

    @Mock
    private User user;

    @Mock
    private CreateUserDTO userDTO;

    @Mock
    private UpdateUserDTO updateUserDTO;

    @InjectMocks
    private UserController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserTest() {
        when(saveUser.create(userDTO)).thenReturn(user);
        assertDoesNotThrow(() -> controller.createUser(userDTO));
    }

    @Test
    void findUserByCpfTest() throws UserNotFoundException {
        when(findUser.findByCpf("12345678901")).thenReturn(user);
        assertDoesNotThrow(() -> controller.findUserByCpf("12345678901"));
    }

    @Test
    void findAllUsersTest() {
        assertDoesNotThrow(() -> controller.findAllUsers());
    }

    @Test
    void deleteUserSuccessTest() throws UserNotFoundException {
        user = new User(userDTO);
        when(findUser.findByCpf("12345678901")).thenReturn(user);
        assertDoesNotThrow(() -> controller.deleteUser("12345678901"));
    }

    @Test
    void updateUserFailTest() throws UserNotFoundException {
        assertDoesNotThrow(() -> controller.updateUser(updateUserDTO));
    }
}

