package com.kamil.Mistrz_klawiatury.controller;

import com.kamil.Mistrz_klawiatury.model.Texts;
import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import com.kamil.Mistrz_klawiatury.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private TextsRepository textsRepository;

    @Autowired
    private UserService userService;

    //add new user to database and redirect to user.jsp
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("registryName") String registryName, @RequestParam("registrySurname") String registrySurname, @RequestParam("registryPassword") String registryPassword, Model model) {
        userService.addNewUser(registryName, registrySurname, registryPassword);
        model.addAttribute("registryName", registryName);
        model.addAttribute("registrySurname", registrySurname);
        model.addAttribute("registryPassword", registryPassword);
        logger.log(Level.INFO, "addUser");
        return "user";
    }

    //from user.jsp to check details in database
    @RequestMapping(value = "/checkData", method = RequestMethod.POST)
    public String checkUserDetails(@RequestParam("nameLogin") String nameLogin, Model model, HttpServletResponse response, HttpServletRequest request) {
        if (userService.userDetails(nameLogin, request, response) != null) {
            model.addAttribute("nameLogin", nameLogin);
            model.addAttribute("txt", textsRepository.findAll());
            return "choose";
        }
        logger.log(Level.INFO, "checkData");
        return "login";
    }

    //choose.jsp to mainContent.jsp
    @RequestMapping(value = "/mainContent", method = RequestMethod.POST)
    public String sendToMyContent(@RequestParam("id") Long id, Model model) {
        Texts txt = userService.textsByValue(id);
        if (txt != null) {
            model.addAttribute("tittle", txt.getTittle());
            model.addAttribute("txt", txt.getText());
            return "mainContent";
        }
        logger.log(Level.INFO, "mainContent");
        return "redirect:/";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main(HttpSession session, HttpServletRequest request, Model model) {
        String loggedUser = userService.loggedUserValue(session, request);
        model.addAttribute("nameLogin", loggedUser);
        model.addAttribute("txt", textsRepository.findAll());
        logger.log(Level.INFO, "main");
        return "choose";
    }
}
