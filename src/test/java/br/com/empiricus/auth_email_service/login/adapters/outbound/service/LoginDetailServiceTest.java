package br.com.empiricus.auth_email_service.login.adapters.outbound.service;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LoginDetailServiceTest {

    @Mock
    private FindUserPort findUser;

    @Mock
    private User user;

    @InjectMocks
    private LoginDetailService service;

    @Test
    void loadUserTest() {
        assertThrows(NullPointerException.class, () -> service.loadUserByUsername("teste"));
    }
}
