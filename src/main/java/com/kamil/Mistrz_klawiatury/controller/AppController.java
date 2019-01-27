package com.kamil.Mistrz_klawiatury.controller;

import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import com.kamil.Mistrz_klawiatury.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
    //wstrzykiwanie UserRepository razem z metodami obsługujacymi bazy danych
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TextsRepository textsRepository;

    //przesyłanei do login.jsp
    @RequestMapping("/login")
    public String logi() {
        return "login";
    }

    //przesylanie z login do registry.jsp
    @RequestMapping("/registry")
    public String sendToRegistry() {
        return "registry";
    }

    //przypadek se StringBuilderem który dodaje nowe stringi zamiast nadisywać
    /*@RequestMapping("/addToDatabase")
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();
        String result = " ";

        Users users = new Users()
                .withName("Kamil")
                .withSurname("Superson")
                .withPassword("qwerty");
        usersRepository.save(users);

        for (Users u : usersRepository.findAll()) {
            response.append(u).append("<br>");
            result = u + "</br>";
        }
        return response.toString();
    }*/

    /*// ukośnik mówi ze to bedzie  startowa metoda
    @RequestMapping("hello")
    //response body mówi ze zostanie zwrócone do przeglądarki ciało metody
    @ResponseBody
    public String mainPage() {
        return "HelloWorld";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        return "loguje";
    }*/
}
