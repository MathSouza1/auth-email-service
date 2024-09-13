package br.com.empiricus.auth_email_service.login.configuration;

import br.com.empiricus.auth_email_service.login.core.service.LoginService;
import br.com.empiricus.auth_email_service.users.core.ports.inbound.FindUserPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class SecurityFilterTest {

    @InjectMocks
    SecurityFilter filter;
    @Mock
    private LoginService loginService;
    @Mock
    private FindUserPort findUser;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private FilterChain filterChain;

    @Test
    void doFilterTest() {
        assertDoesNotThrow(() -> filter.doFilterInternal(request, response, filterChain));
    }
}
