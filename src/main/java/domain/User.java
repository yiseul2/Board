package domain;

import java.sql.Timestamp;

public class User {
    private Long id;
    private String account_id;
    private String password;
    private String nickname;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Long getId() {
        return id;
    }
    public String getAccount_id() {
        return account_id;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }
    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
