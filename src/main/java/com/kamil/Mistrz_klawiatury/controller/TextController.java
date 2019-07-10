package com.kamil.Mistrz_klawiatury.controller;

import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import com.kamil.Mistrz_klawiatury.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/")
public class TextController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    TextsRepository textsRepository;

    //pobiera jako parametr tytuł i text dodatkowego wiersza poza baza anych i przesyła to do mainContent.jsp
    @RequestMapping("/extraContent")
    public String sendExtraText(@RequestParam("tittle") String tittle, @RequestParam("text") String text, Model model) {
        model.addAttribute("tittle", tittle.trim());
        model.addAttribute("text", text.trim());
        return "mainContent";
    }

    @RequestMapping("/summary")
    public String summary(HttpServletRequest request, @RequestParam("userSummmary")Integer counter, @RequestParam("hiddenTimer")Long hiddenTimer, Model model) {


        Long currentTime = new Date().getTime();
        Long miliseconds = currentTime - hiddenTimer;
        Long minutes = miliseconds/1000/60;
        Long seconds = (miliseconds/1000)%60;
        String parsedTime = String.format("%d Minutes and %d Seconds",minutes,seconds);
        model.addAttribute("counter","discrapency :" + counter);
        model.addAttribute("endTime",parsedTime);
        return "summaryPage";
    }
}
