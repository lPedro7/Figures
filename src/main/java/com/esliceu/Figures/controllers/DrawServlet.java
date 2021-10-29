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
import java.io.Writer;
import java.util.List;
import java.util.Random;

@WebServlet(value = "/private/draw")
public class DrawServlet extends HttpServlet {
    FiguraService figuraService = new FiguraService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomFigura = req.getParameter("name");
        String tipus = req.getParameter("tipus");
        String coordX = req.getParameter("coordsX");
        String coordY = req.getParameter("coordsY");
        String grandaria = req.getParameter("grandaria");
        String color = req.getParameter("color");
        figuraService.checkFigure(nomFigura,tipus,coordX,coordY,grandaria,color, req);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);

    }



}

