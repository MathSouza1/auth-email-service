package br.com.empiricus.auth_email_service.emails.core.dtos;

import br.com.empiricus.auth_email_service.emails.adapters.outbound.entity.EmailEntity;

public class SendEmailDTO {

    private String email;

    public SendEmailDTO() {
    }

    public SendEmailDTO(String email) {
        this.email = email;
    }

    public SendEmailDTO(EmailEntity emailEntity) {
        this.email = emailEntity.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
