package com.esliceu.Figures.controllers;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import com.esliceu.Figures.services.FiguraService;
import com.esliceu.Figures.services.FiguraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import java.util.List;

@Controller
public class CombineController{

    @Autowired
    HttpSession session;
    @Autowired
    FiguraService figuraService;


    @GetMapping("/private/combine")
    public String showFigures() {

        List<Figura> figures = figuraService.figuresByUser((String) session.getAttribute("username"));
        session.setAttribute("figures", figures);
        return "combine";
    }

    @PostMapping("/private/combine")
    public RedirectView combine(@RequestParam String figura1,@RequestParam String figura2,@RequestParam String nom) {

        figuraService.combineFigures(figura1, figura2, nom, (String) session.getAttribute("username"));

        return new RedirectView("/private/figures");
    }
}

