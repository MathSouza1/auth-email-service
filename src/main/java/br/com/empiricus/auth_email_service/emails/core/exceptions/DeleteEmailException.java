package br.com.empiricus.auth_email_service.emails.core.exceptions;

public class DeleteEmailException extends Exception {

    public DeleteEmailException() {
        super("Error while deleting email.");
    }

    public DeleteEmailException(String message) {
        super(message);
    }
}
