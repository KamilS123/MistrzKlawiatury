package com.kamil.Mistrz_klawiatury.controller;

import com.kamil.Mistrz_klawiatury.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class AppController {

    private final Logger logger = Logger.getLogger(AppController.class.getName());
    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    //redirect to login.jsp
    @RequestMapping("/")
    public String login() {
        logger.log(Level.INFO, "redirect to login");
        return "login";
    }

    //redirect from login to registry.jsp
    @RequestMapping("/registry")
    public String sendToRegistry() {
        logger.log(Level.INFO, "registry");
        return "registry";
    }

    //logout
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        logger.log(Level.INFO, "logout");
        return appService.cancelCookie(request);
    }
}

