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
import java.util.List;


@WebServlet(value = "/private/figures")
public class OwnFiguresController extends HttpServlet {
    HttpSession session;
    FiguraDao figuraDao;
    List<Figura> figuras;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        figuraDao = new FiguraDaoImpl();
        figuras = figuraDao.getFiguresByUser((String) session.getAttribute("username"));

        session.setAttribute("figures", figuras);

        System.out.println("hola");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/ownfigures.jsp");
        dispatcher.forward(req, resp);
    }

}
