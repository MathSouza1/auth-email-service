package br.com.empiricus.auth_email_service.emails.core.exceptions;

public class SaveEmailException extends Exception {
    public SaveEmailException() {
        super("Error while saving email.");
    }

    public SaveEmailException(String message) {
        super(message);
    }
}
