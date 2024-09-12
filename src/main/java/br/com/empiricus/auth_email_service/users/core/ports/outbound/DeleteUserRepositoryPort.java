package br.com.empiricus.auth_email_service.users.core.ports.outbound;

public interface DeleteUserRepositoryPort {

    void execute(String cpf);
}
