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
        model.addAttribute("tittle", tittle.trim());
        model.addAttribute("text", text.trim());
        return "mainContent";
    }

    @RequestMapping("/summary")
    public String summary(@RequestParam("tarea2")String textToWrite, @RequestParam("tarea1")String textToRepeat, Model model) {
        char[]toRepeat = textToRepeat.toCharArray();
        char[]toWrite = textToWrite.toCharArray();
        int counter = 0;
        for(int i = 0; i<textToRepeat.length()-1; i++) {
            if (toRepeat[i]!=toWrite[i]) {
                counter++;
            }
        }
        model.addAttribute("counter",counter);
        return "summaryPage";
    }
}
