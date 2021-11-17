package com.esliceu.Figures.controllers;

import com.esliceu.Figures.services.FiguraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DrawController{

    @Autowired
    FiguraService figuraService;

    @GetMapping("/private/draw")
    public String draw(){return "draw";}

    @PostMapping("/private/draw")
    public RedirectView createFigura(@RequestParam String name, @RequestParam String tipus, @RequestParam String coordsX, @RequestParam String coordsY, @RequestParam String grandaria, @RequestParam String color){

        figuraService.checkFigure(name,tipus,coordsX,coordsY,grandaria,color);

        return new RedirectView("/private/figures");
    }


}

