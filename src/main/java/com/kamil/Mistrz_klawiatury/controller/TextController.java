package com.kamil.Mistrz_klawiatury.controller;

import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import com.kamil.Mistrz_klawiatury.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("tittle", tittle);
        model.addAttribute("text", text.trim());
        return "mainContent";
    }
}
