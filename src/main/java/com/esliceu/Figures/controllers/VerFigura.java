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

@WebServlet(value = "/private/verfigura")
public class VerFigura extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FiguraDao figuraDao = new FiguraDaoImpl();
        HttpSession session = req.getSession();
        String nomFigura = req.getParameter("nom");
        String userOwner = req.getParameter("user_owner");

        Figura figura = figuraDao.getFigura(nomFigura,userOwner);

        session.setAttribute("verFigura",figura);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/verfigura.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/verfigura.jsp");
        dispatcher.forward(req, resp);    }
}
