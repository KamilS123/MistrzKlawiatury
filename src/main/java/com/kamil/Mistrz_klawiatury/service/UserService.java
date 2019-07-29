package com.kamil.Mistrz_klawiatury.service;

import com.kamil.Mistrz_klawiatury.model.Texts;
import com.kamil.Mistrz_klawiatury.model.Users;
import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import com.kamil.Mistrz_klawiatury.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TextsRepository textsRepository;

    public void addNewUser(String registryName, String registrySurname, String registryPassword) {
        List<Users> userList = (List<Users>) usersRepository.findAll();
        Optional<Users> user = userList.stream()
                .filter(s -> s.getusername().equals(registryName))
                .findAny();
        if (user.isPresent()) {
            throw new IllegalArgumentException("User is already in database");
        } else {
            Users users = new Users()
                    .withName(registryName)
                    .withSurname(registrySurname)
                    .withPassword(registryPassword);
            usersRepository.save(users);
        }
    }
    public String loggedUserValue(HttpSession session, HttpServletRequest request) {
        String loggedUser = (String) session.getAttribute("user");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if (cookie.getName().equals(loggedUser)) {
                loggedUser = cookie.getValue();
                System.out.println(loggedUser + " logged ");
            }
        }
        return loggedUser;
    }

    public Texts textsByValue(Long id) {
        List<Texts> textsList = (List<Texts>) textsRepository.findAll();
        return textsList.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .orElseThrow(()->new NullPointerException("Text with choosen id is not present"));
    }
    public Users userDetails(String nameLogin, HttpServletRequest request, HttpServletResponse response) {
        List<Users> usersList = (List<Users>) usersRepository.findAll();
        Users user = usersList.stream()
                .filter(s->s.getusername().equals(nameLogin))
                .findFirst()
                .orElseThrow(()->new NullPointerException("user with passed name don`t exist"));
        if (user!=null) {
            setCookie(request,response,nameLogin);
        }else {
            System.out.println("cookie not set up");
        }
       return user;
    }
    private Cookie setCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        HttpSession session = request.getSession();
        session.setAttribute("user",name);
        session.setMaxInactiveInterval(30*60);
        Cookie cookie = new Cookie("user", name);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
        return cookie;
    }
}
