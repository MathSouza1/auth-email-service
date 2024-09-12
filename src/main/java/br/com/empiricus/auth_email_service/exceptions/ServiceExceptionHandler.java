package br.com.empiricus.auth_email_service.exceptions;

import br.com.empiricus.auth_email_service.users.core.exceptions.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ServiceErrorMessage> userNotFoundHandler(UserNotFoundException exception) {
        ServiceErrorMessage errorMessage = new ServiceErrorMessage(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ServiceErrorMessage> unUniqueFieldErrorMessage(DataIntegrityViolationException exception) {
        ServiceErrorMessage errorMessage = new ServiceErrorMessage(
                new Date(),
                HttpStatus.CONFLICT.value(),
                Objects.requireNonNull(exception.getRootCause()).getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ServiceErrorMessage> unformedFieldErrorMessage(ConstraintViolationException exception) {
        ServiceErrorMessage errorMessage = new ServiceErrorMessage(
                new Date(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorMessage);
    }
}
