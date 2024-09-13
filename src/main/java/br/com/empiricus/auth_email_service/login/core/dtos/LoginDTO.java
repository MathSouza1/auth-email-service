package br.com.empiricus.auth_email_service.login.core.dtos;

public class LoginDTO {

    private String cpf;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
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
}
