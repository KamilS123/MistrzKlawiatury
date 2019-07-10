package com.kamil.Mistrz_klawiatury.controller;

import com.kamil.Mistrz_klawiatury.model.Texts;
import com.kamil.Mistrz_klawiatury.model.Users;
import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import com.kamil.Mistrz_klawiatury.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    TextsRepository textsRepository;

    //dodawanie nowego uzytkownika do bazy danych i przekierowanie do user.jsp
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("registryName") String registryName, @RequestParam("registrySurname") String registrySurname, @RequestParam("registryPassword") String registryPassword, Model model) {
        //ustawia atrybuty przekazane do form w registry.jsp
        model.addAttribute("registryName", registryName);
        model.addAttribute("registrySurname", registrySurname);
        model.addAttribute("registryPassword", registryPassword);

        //tworzenie nowego obiektu user przez pobranie z fornularza login.jsp danych
        Users users = new Users()
                .withName(registryName)
                .withSurname(registrySurname)
                .withPassword(registryPassword);
        //zapis nowego uzytkownika do bazy danych przez wbudowaną metode save
        usersRepository.save(users);
        return "user";
    }

    //odebranie z user.jsp w celu sprawdzenia czy dane logujacego sie znajduja sie w bazie danych
    @RequestMapping(value = "/checkData", method = RequestMethod.POST)
    public String checkUserDetails(@RequestParam("nameLogin") String nameLogin, @RequestParam("surmaneLogin") String surmaneLogin, @RequestParam("passwordLogin") String passwordLogin, Model model,HttpServletResponse response) {
        //bierzemy całą baze danych do listy usersList
        List<Users> usersList = (List<Users>) usersRepository.findAll();
        List<Texts> textsList = (List<Texts>) textsRepository.findAll();

        //iterujemy liste. Jeśli parametry sie zgadzają to przechodzimy to choose.jsp
        for (Users u : usersList) {
            if (u.getPassword().equals(passwordLogin) && u.getSurname().equals(surmaneLogin) && u.getusername().equals(nameLogin)) {
                setCookie(response, nameLogin);
                model.addAttribute("txt", textsList);
                model.addAttribute("nameLogin", nameLogin);
                return "choose";
            }
        }
        return "login";
    }

    //wysyła z choose.jsp do mainContent.jsp
    @RequestMapping(value = "/mainContent", method = RequestMethod.POST)
    public String sendToMyContent(@RequestParam("id") String id, Model model) {
        //parsuje pobrane id na long
        Long longId = Long.parseLong(id);
        //umieszcza cała baze obiektu Texts do listy testsList
        List<Texts> textsList = (List<Texts>) textsRepository.findAll();
        //iteruje po liście. Jęśli zawiera id to ustawia atrubuty
        for (Texts texts : textsList) {
            if (texts.getId().equals(longId)) {
                model.addAttribute("wybranyWiersz", texts.getText());
                model.addAttribute("wybranyTytul", texts.getTittle());
                return "mainContent";
            }
        }
        return "";
    }
    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String main(Model model) {
        List<Texts> textsList = (List<Texts>) textsRepository.findAll();
        model.addAttribute("txt", textsList);
        return "choose";
    }

    public Cookie setCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name,name);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
        return cookie;
    }
}
