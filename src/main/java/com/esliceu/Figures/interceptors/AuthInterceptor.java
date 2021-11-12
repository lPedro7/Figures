package com.esliceu.Figures.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component("authInt")
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("dentro del interceptor");

        String username = (String) session.getAttribute("username");
        if (username == null){
            response.sendError(403);
            return false;
        }
        return true;
    }
}
