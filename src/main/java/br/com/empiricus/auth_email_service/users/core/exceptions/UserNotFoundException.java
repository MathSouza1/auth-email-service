package br.com.empiricus.auth_email_service.users.core.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User NOT found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
