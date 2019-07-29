package com.kamil.Mistrz_klawiatury.service;

        import org.springframework.stereotype.Service;

        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;

@Service
public class AppService {
    public String cancelCookie(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String loggedUser = (String) session.getAttribute("user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(loggedUser)) {
                cookie.setMaxAge(0);
            }
            return "login";
        }
        return "login";
    }
}
