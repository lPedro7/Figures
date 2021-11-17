package com.esliceu.Figures.services;

import com.esliceu.Figures.daos.FiguraDao;
import com.esliceu.Figures.daos.FiguraDaoImpl;
import com.esliceu.Figures.models.Figura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface FiguraService {

    void checkFigure(String nomFigura, String tipus, String coordX, String coordY, String grandaria, String color);

    boolean isNumber(String s);

    boolean checkName(List<Figura> figuras, String name);

    void combineFigures(String figura1, String figura2,String nom, String username);

    List<Figura> allFigures();

    List<Figura> figuresByUser(@RequestParam String username);

    void removeFigura(String nomFigura);

    Figura figuraByUser(String nomFigura,String username_owner);


}
