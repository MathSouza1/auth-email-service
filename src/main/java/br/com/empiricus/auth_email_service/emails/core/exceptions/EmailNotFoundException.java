package br.com.empiricus.auth_email_service.emails.core.exceptions;

public class EmailNotFoundException extends Exception {

    public EmailNotFoundException() {
        super("Email NOT found.");
    }

    public EmailNotFoundException(String message) {
        super(message);
    }
}
