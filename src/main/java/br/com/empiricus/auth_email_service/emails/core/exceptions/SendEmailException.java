package br.com.empiricus.auth_email_service.emails.core.exceptions;

public class SendEmailException extends Exception {

    public SendEmailException() {
        super("Error while saving email.");
    }

    public SendEmailException(String message) {
        super(message);
    }
}
