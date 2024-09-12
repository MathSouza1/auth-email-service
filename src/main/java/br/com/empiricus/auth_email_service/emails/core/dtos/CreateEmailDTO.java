package br.com.empiricus.auth_email_service.emails.core.dtos;

public class CreateEmailDTO {

    private String id;

    private String cpf;

    private String email;
    private boolean admin;

    public CreateEmailDTO() {
    }

    public CreateEmailDTO(String id, String cpf, String email, boolean admin) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.admin = admin;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
