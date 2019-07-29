package com.kamil.Mistrz_klawiatury.controller;


import com.kamil.Mistrz_klawiatury.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class TextController {

    private final Logger logger = Logger.getLogger(TextController.class.getName());

    @Autowired
    private TextService textService;

    //fetch user tittle text and send it to mainContent.jsp
    @RequestMapping("/extraContent")
    public String sendExtraText(@RequestParam("tittle") String tittle, @RequestParam("text") String text, Model model) {
        model.addAttribute("tittle", tittle.trim());
        model.addAttribute("text", text.trim());
        logger.log(Level.INFO, "extraContent");
        return "mainContent";
    }

    //redirect to summary with scores with diffirent between end and start time
    @RequestMapping("/summary")
    public String summary(@RequestParam("userSummmary") Integer counter, @RequestParam("hiddenTimer") Long hiddenTimer, Model model) {
        String parsedTime = textService.endMinusStartTime(hiddenTimer);
        if (counter == null) {
            counter = 0;
        }
        model.addAttribute("counter", "discrapency :" + counter);
        model.addAttribute("endTime", parsedTime);
        logger.log(Level.INFO, "summary");
        return "summaryPage";
    }
}
