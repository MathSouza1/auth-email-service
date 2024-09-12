package br.com.empiricus.auth_email_service.emails.adapters.outbound.entity;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
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
@Table(name = "emails")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(unique = true)
    @jakarta.validation.constraints.Email
    private String email;

    @Column(name = "data_criacao")
    private String creationDate;

    @Column(name = "data_atualizacao")
    private String updateDate;

    @CPF
    @NotBlank
    private String cpf;

    @Column(name = "eh_admin")
    private boolean admin;

    public Email toEmail() {
        return new Email(this.id, this.cpf, this.email, this.creationDate, this.updateDate, this.admin);
    }
}
