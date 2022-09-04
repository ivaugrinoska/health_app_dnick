package com.example.health_app_dnick.model.pk;

import java.io.Serializable;

public class UserReadBooksPK implements Serializable {

    private Long readBooksId;
    private String username;

    public UserReadBooksPK() {
    }

    public UserReadBooksPK(Long readBooksId, String username) {
        this.readBooksId = readBooksId;
        this.username = username;
    }

    public Long getReadBooksId() {
        return readBooksId;
    }

    public void setReadBooksId(Long readBooksId) {
        this.readBooksId = readBooksId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
