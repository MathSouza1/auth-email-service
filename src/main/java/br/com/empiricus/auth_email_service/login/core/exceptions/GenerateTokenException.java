package br.com.empiricus.auth_email_service.login.core.exceptions;

public class GenerateTokenException extends Exception {
    public GenerateTokenException() {
    }

    public GenerateTokenException(String message) {
        super(message);
    }
}
