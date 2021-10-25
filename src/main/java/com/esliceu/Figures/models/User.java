package com.esliceu.Figures.models;

import java.util.List;

public class User {

    private String username;
    private String password;
    private List<Figura> figures;

    public List<Figura> getFigures() {
        return figures;
    }

    public void setFigures(List<Figura> figures) {
        this.figures = figures;
    }

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
}
