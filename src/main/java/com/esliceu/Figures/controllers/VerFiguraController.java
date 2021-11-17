package com.esliceu.Figures.controllers;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import com.esliceu.Figures.services.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class VerFiguraController {
    @Autowired
    FiguraDao figuraDao;

    @Autowired
    FiguraService figuraService;

    @Autowired
    HttpSession session;

    @GetMapping("/private/verfigura")
    public String verFigura(@RequestParam String nom, @RequestParam String user_owner){

        Figura figura = figuraService.figuraByUser(nom,user_owner);

        session.setAttribute("verFigura",figura);

        if (figura.isComposed()){
            session.setAttribute("figura2", figuraService.figuraByUser(figura.getNomFigura2(), (String) session.getAttribute("username")));
        }

        return "verfigura";
    }

}
