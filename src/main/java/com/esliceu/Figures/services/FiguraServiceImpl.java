package com.esliceu.Figures.services;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FiguraServiceImpl implements FiguraService {

    @Autowired
    FiguraDao figuraDao;

    @Autowired
    HttpSession session;

    @Override
    public void checkFigure(String nomFigura, String tipus, String coordX, String coordY, String grandaria, String color) {
        boolean check = true;

        List<Figura> figuras = figuraDao.getFiguresByUser((String) session.getAttribute("username"));
        String errorMessage = "";

        if (!isNumber(coordX)) {
            errorMessage = "La coordenada X ha de ser un nombre";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (Integer.parseInt(coordX) < 0 || Integer.parseInt(coordX) >= 1024) {
            errorMessage = "La coordenada X ha de ser major a 0 i menor a 1024";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (!isNumber(coordY)) {
            errorMessage = "La coordenada Y ha de ser un nombre";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (Integer.parseInt(coordY) < 0 || Integer.parseInt(coordY) >= 768) {
            errorMessage = "La coordenada Y ha de ser major a 0 i menor a 768";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (!isNumber(grandaria)) {
            errorMessage = "La grandària ha de ser un nombre";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (Integer.parseInt(grandaria) <= 0) {
            errorMessage = "La grandària ha de ser major a 0";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (!checkName(figuras, nomFigura)) {
            errorMessage = "El nom de la figura ja existeix";
            session.setAttribute("errorMessage", errorMessage);
            check = false;
        } else if (nomFigura.equals("")) {
            nomFigura = tipus + Math.round(Math.random() * 100);
            while (!checkName(figuras, nomFigura)) {
                nomFigura = tipus + Math.round(Math.random() * 100);
            }
        }


        if (check) {
            errorMessage = null;
            session.setAttribute("nomFigura", nomFigura);
            session.setAttribute("tipusFigura", tipus);
            session.setAttribute("coordX", Integer.parseInt(coordX));
            session.setAttribute("coordY", Integer.parseInt(coordY));
            session.setAttribute("grandaria", Integer.parseInt(grandaria));
            session.setAttribute("color", color);

            Figura f = new Figura();
            f.setNom(nomFigura);
            f.setTipus(tipus);
            f.setCoordX(Integer.parseInt(coordX));
            f.setCoordY(Integer.parseInt(coordY));
            f.setColor(color);
            f.setGrandaria(Integer.parseInt(grandaria));
            f.setUsername_owner((String) session.getAttribute("username"));
            f.setNomFigura2("");
            f.setComposed(false);
            figuraDao.createFigura(f);


        }
    }

    @Override
    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkName(List<Figura> figuras, String name) {
        for (Figura f : figuras) {
            if (f.getNom().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void combineFigures(String figura1, String figura2,String nom, String username){

        Figura fig1 = figuraDao.getFigura(figura1,username);

        Figura f = new Figura();
        f.setNom(nom);
        f.setTipus(fig1.getTipus());
        f.setCoordX(fig1.getCoordX());
        f.setCoordY(fig1.getCoordY());
        f.setColor(fig1.getColor());
        f.setGrandaria(fig1.getGrandaria());
        f.setUsername_owner(fig1.getUsername_owner());
        f.setNomFigura2(figura2);
        f.setComposed(true);
        figuraDao.createFigura(f);
    }

    @Override
    public List<Figura> allFigures(){
        return figuraDao.getFigures();
    }

    @Override
    public List<Figura> figuresByUser(@RequestParam String username){
        return figuraDao.getFiguresByUser(username);
    }

    @Override
    public void removeFigura(String nomFigura){

        Figura f = figuraDao.getFigura(nomFigura, (String) session.getAttribute("username"));

        figuraDao.deleteFigura(f);
    }

    @Override
    public Figura figuraByUser(String nomFigura, String username_owner) {
        return figuraDao.getFigura(nomFigura,username_owner);
    }



}
