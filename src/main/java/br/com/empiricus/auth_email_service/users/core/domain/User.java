package br.com.empiricus.auth_email_service.users.core.domain;

import br.com.empiricus.auth_email_service.users.adapters.outbound.entity.UserEntity;

public class User {

    private String id;
    private String name;
    private String cpf;
    private String password;
    private String creationDate;
    private String updateDate;
    private boolean admin;

    public User() {
    }

    public User(String id, String name, String cpf, String password, String creationDate, String updateDate, boolean admin) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.admin = admin;
    }

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.cpf = userEntity.getCpf();
        this.password = userEntity.getPassword();
        this.creationDate = userEntity.getCreationDate();
        this.updateDate = userEntity.getUpdateDate();
        this.admin = userEntity.isAdmin();
    }

    public String getId() {
        return id;
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

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
