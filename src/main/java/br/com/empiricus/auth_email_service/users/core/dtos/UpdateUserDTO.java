package br.com.empiricus.auth_email_service.users.core.dtos;

public class UpdateUserDTO {

    private String id;
    private String cpf;
    private String name;
    private String password;
    private String creationDate;
    private boolean admin;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String id, String cpf, String name, String password, String creationDate, boolean admin) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.creationDate = creationDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
