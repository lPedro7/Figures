package com.esliceu.Figures.controllers;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/private/figures")
public class OwnFiguresServlet extends HttpServlet {
    @Autowired
    HttpSession session;

    @Autowired
    FiguraDao figuraDao;

    List<Figura> figuras;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        figuraDao = new FiguraDaoImpl();
        figuras = figuraDao.getFiguresByUser((String) session.getAttribute("username"));

        session.setAttribute("figures", figuras);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/ownfigures.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomFigura = req.getParameter("nom");

        FiguraDao figuraDao = new FiguraDaoImpl();


        Figura f = figuraDao.getFigura(nomFigura, (String) session.getAttribute("username"));

        figuraDao.deleteFigura(f);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/ownfigures.jsp");
        dispatcher.forward(req, resp);
    }
}
