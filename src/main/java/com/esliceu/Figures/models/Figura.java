package com.esliceu.Figures.models;

public class Figura {

    private String nom;
    private String username_owner;
    private String tipus;
    private int coordX;
    private int coordY;
    private String color;
    private int grandaria;
    private String nomFigura2;
    private boolean composed;


    public boolean isComposed() {
        return composed;
    }

    public void setComposed(boolean composed) {
        this.composed = composed;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername_owner() {
        return username_owner;
    }

    public void setUsername_owner(String username_owner) {
        this.username_owner = username_owner;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getGrandaria() {
        return grandaria;
    }

    public void setGrandaria(int grandaria) {
        this.grandaria = grandaria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getNomFigura2() {
        return nomFigura2;
    }

    public void setNomFigura2(String nomFigura2) {
        this.nomFigura2 = nomFigura2;
    }
}
