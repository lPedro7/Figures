package com.esliceu.Figures.daos;

import com.esliceu.Figures.models.Figura;

import java.util.List;

public interface FiguraDao {
    Figura getFigura(String nom_Figura, String username_owner);
    List<Figura> getFigures();
    List<Figura> getFiguresByUser(String username);
    void createFigura(Figura figura);
    void deleteFigura(Figura figura);
}
