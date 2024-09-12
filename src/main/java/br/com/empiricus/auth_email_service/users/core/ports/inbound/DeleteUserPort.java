package br.com.empiricus.auth_email_service.users.core.ports.inbound;

public interface DeleteUserPort {

    void execute(String cpf);
}
