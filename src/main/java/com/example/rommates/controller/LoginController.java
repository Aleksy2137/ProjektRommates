package com.example.rommates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Zwraca nazwę widoku formularza logowania (np. "login.html")
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model) {
        try {
            // Próba zalogowania użytkownika
            request.login(password, username);
            return "redirect:/"; // Przekierowanie do strony głównej po pomyślnym zalogowaniu
        } catch (ServletException e) {
            // Obsługa błędu logowania
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Powrót do formularza logowania z komunikatem o błędzie
        }
    }
}

