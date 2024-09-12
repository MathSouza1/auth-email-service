package br.com.empiricus.auth_email_service.emails.core.dtos;

import br.com.empiricus.auth_email_service.emails.adapter.outbound.entity.EmailEntity;

public class EmailsListDTO {

    private String id;
    private String email;

    public EmailsListDTO() {
    }

    public EmailsListDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public EmailsListDTO(EmailEntity emailEntity) {
        this.id = emailEntity.getId();
        this.email = emailEntity.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
