package com.esliceu.Figures.controllers;

import com.esliceu.Figures.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        LoginService loginService = new LoginService();

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        boolean login = loginService.loginOk(username, password);

        if (!login) {
            req.setAttribute("loginMessage", "Usuari o password incorrecte");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            session.setAttribute("auth", true);
            session.setAttribute("username", username);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/loginok.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
