package com.example.p7apiweb.viewmodel;

import com.sun.istack.NotNull;

public class ClientModel {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    private String username;
    @NotNull
    private String password;
}
