package br.com.empiricus.auth_email_service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceErrorMessage {
    private Date timestamp;
    private int status;
    private String error;
}
