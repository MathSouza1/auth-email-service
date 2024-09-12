package br.com.empiricus.auth_email_service.emails.core.domain;

import br.com.empiricus.auth_email_service.emails.core.dtos.CreateEmailDTO;

import java.time.LocalDateTime;

public class Email {

    private String id;
    private String cpf;
    private String email;
    private String creationDate;
    private String updateDate;
    private boolean admin;

    public Email() {
    }

    public Email(String id, String cpf, String email, String creationDate, String updateDate, boolean admin) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.admin = admin;
    }

    public Email(CreateEmailDTO createEmailDTO) {
        this.cpf = createEmailDTO.getCpf();
        this.email = createEmailDTO.getEmail();
        this.creationDate = LocalDateTime.now().toString();
        this.updateDate = LocalDateTime.now().toString();
        this.admin = createEmailDTO.isAdmin();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
