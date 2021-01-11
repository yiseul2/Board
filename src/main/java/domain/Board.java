package domain;

import java.sql.Timestamp;

public class Board {
    private Long id;
    private Long user_id;
    private String title;
    private String content;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Long getId() {
        return id;
    }
    public Long getUser_id() {
        return user_id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
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
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
