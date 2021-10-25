package com.esliceu.Figures.controllers;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(value = "/private/draw")
public class DrawController extends HttpServlet {
    String errorMessage;
    FiguraDao figuraDao = new FiguraDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        boolean check = true;
        String nomFigura = req.getParameter("name");
        String tipus = req.getParameter("tipus");
        String coordX = req.getParameter("coordsX");
        String coordY = req.getParameter("coordsY");
        String grandaria = req.getParameter("grandaria");
        String color = req.getParameter("color");
        List<Figura> figuras = figuraDao.getFiguresByUser((String) session.getAttribute("username"));


        if (!isNumber(coordX)) {
            errorMessage = "La coordenada X ha de ser un nombre";
            session.setAttribute("errorMessage",errorMessage);
            check = false;
        } else if (!isNumber(coordY)) {
            errorMessage = "La coordenada Y ha de ser un nombre";
            session.setAttribute("errorMessage",errorMessage);
            check = false;
        } else if (!isNumber(grandaria)) {
            errorMessage = "La grandària ha de ser un nombre";
            session.setAttribute("errorMessage",errorMessage);
            check = false;
        }else if(!checkName(figuras,nomFigura)){
            errorMessage = "El nom de la figura ja existeix";
            session.setAttribute("errorMessage",errorMessage);
            check=false;
        }

        System.out.println(check);

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
            figuraDao.createFigura(f);

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);

    }


    boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    boolean checkName(List<Figura> figuras, String name ){
        for(Figura f : figuras){
            if (f.getNom().equals(name)){
                return false;
            }
        }
        return true;
    }
}

