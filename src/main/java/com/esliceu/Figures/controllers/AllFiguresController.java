package com.esliceu.Figures.controllers;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import com.esliceu.Figures.services.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AllFiguresController{

    @Autowired
    HttpSession session;

    @Autowired
    FiguraService figuraService;

    List<Figura> figuras;

    @GetMapping("/private/allfigures")
    public String allFiguras(){
        figuras = figuraService.allFigures();

        session.setAttribute("allfigures", figuras);

        return "allfigures";
    }

}
