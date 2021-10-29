package com.esliceu.Figures.controllers;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import com.esliceu.Figures.services.FiguraService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/private/combine")
public class CombineServlet extends HttpServlet {

    FiguraDao figuraDao = new FiguraDaoImpl();
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Figura> figures = figuraDao.getFiguresByUser((String) req.getAttribute("username"));
        session = req.getSession();
        session.setAttribute("figures",figures);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/combine.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomFigura1 = req.getParameter("figura1");
        String nomFigura2 = req.getParameter("figura2");
        String nom = req.getParameter("nom");

        FiguraService figuraService = new FiguraService();


        figuraService.combineFigures(nomFigura1,nomFigura2,nom, (String) req.getAttribute("username"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/combine.jsp");
        dispatcher.forward(req, resp);}
}
