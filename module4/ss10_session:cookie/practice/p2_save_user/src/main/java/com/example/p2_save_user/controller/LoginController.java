package com.example.p2_save_user.controller;

import com.example.p2_save_user.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, @ModelAttribute("user") User user, Model model) {
        user.setEmail("");
        model.addAttribute("cookieValue", setUser);
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response) {
        Cookie cookie = new Cookie("setUser", setUser);

        if (user.getEmail().equals("admin") && user.getPassword().equals("123")) {
            setUser = user.getEmail();
            cookie.setValue(setUser);
            cookie.setMaxAge(24 * 60 * 60);

            model.addAttribute("cookieValue", setUser);
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            cookie.setValue("");
            cookie.setMaxAge(0);

            model.addAttribute("message", "Login failed. Try again.");
        }

        response.addCookie(cookie);

        return "login";
    }
}
