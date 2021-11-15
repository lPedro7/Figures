package com.esliceu.Figures.controllers;

import com.esliceu.Figures.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController{

    @Autowired
    LoginService loginService;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(Model model,@RequestParam String username, @RequestParam String password){

        if(loginService.loginOk(username, password)){
                session.setAttribute("username",username);
               return "loginok";
        }
        model.addAttribute("message", "Usuari o password incorrectes");
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
