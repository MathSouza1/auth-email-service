package br.com.empiricus.auth_email_service.users.adapters.outbound.entity;

import br.com.empiricus.auth_email_service.users.core.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @CPF
    @NotBlank
    @Column(updatable = true, unique = true)
    private String cpf;

    @NotBlank
    private String password;

    @Column(name = "data_criacao")
    private String creationDate;

    @Column(name = "data_atualizacao")
    private String updateDate;

    @Column(name = "eh_admin")
    private boolean admin;

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.password = user.getPassword();
        this.creationDate = user.getCreationDate();
        this.updateDate = user.getUpdateDate();
        this.admin = user.getAdmin();
    }

    public User toUser() {
        return new User(this.id, this.name, this.cpf, this.password, this.creationDate, this.updateDate, this.admin);
    }
}
