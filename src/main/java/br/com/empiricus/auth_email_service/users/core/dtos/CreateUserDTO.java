package br.com.empiricus.auth_email_service.users.core.dtos;

public class CreateUserDTO {

    private String name;
    private String cpf;
    private String password;
    private boolean admin;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String name, String cpf, String password, boolean admin) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
