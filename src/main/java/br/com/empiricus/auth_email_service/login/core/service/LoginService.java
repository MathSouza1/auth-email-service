package br.com.empiricus.auth_email_service.login.core.service;

import br.com.empiricus.auth_email_service.login.core.exceptions.GenerateTokenException;
import br.com.empiricus.auth_email_service.login.core.ports.inbound.LoginPort;
import br.com.empiricus.auth_email_service.users.core.domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LoginService implements LoginPort {

    @Value("${security.token.secretKey}")
    private String secretKey;

    @Override
    public String generateToken(User user) throws GenerateTokenException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("auth-email-service")
                    .withSubject(user.getCpf())
                    .withExpiresAt(tokenExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new GenerateTokenException(exception.getLocalizedMessage());
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("auth-email-service")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant tokenExpirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
