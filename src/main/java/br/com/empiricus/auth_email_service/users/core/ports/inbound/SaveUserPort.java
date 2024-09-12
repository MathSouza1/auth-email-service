package br.com.empiricus.auth_email_service.users.core.ports.inbound;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import br.com.empiricus.auth_email_service.users.core.dtos.CreateUserDTO;
import br.com.empiricus.auth_email_service.users.core.dtos.UpdateUserDTO;

public interface SaveUserPort {
    User create(CreateUserDTO createUserDTO);

    User update(UpdateUserDTO updateUserDTO);
}
