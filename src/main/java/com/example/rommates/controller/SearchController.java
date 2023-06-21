package com.example.rommates.controller;

import com.example.rommates.model.User;
import com.example.rommates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public String searchUsersByCity(@RequestParam String city, Model model) {
        // Pobierz listę użytkowników z bazy danych na podstawie miasta
        List<User> users = userService.findByCity(city);

        // Dodaj listę użytkowników do modelu, aby można było jej użyć w widoku
        model.addAttribute("users", users);

        // Zwróć nazwę widoku, który ma być wyrenderowany (w tym przypadku "searchResults.html")
        return "searchResults";
    }
}
