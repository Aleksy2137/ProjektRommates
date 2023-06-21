package com.example.rommates.controller;

import com.example.rommates.model.User;
import com.example.rommates.service.ListService;
import com.example.rommates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ListService listService;

    @GetMapping("/user/{id}")
    public String viewProfile(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/message/{id}")
    public String messageUser(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "message";
    }

    @GetMapping("/add-to-list/{id}")
    public String addToList(@PathVariable int id, Model model, Principal principal) {
        User user = userService.findById(id);
        Long userId = /* Pobierz ID zalogowanego użytkownika za pomocą obiektu Principal */;
        model.addAttribute("user", user);
        model.addAttribute("lists", listService.findByUserId(userId));
        return "add-to-list";
    }
    @GetMapping("/add-user-to-list/{listId}/{userId}")
    public String addUserToSpecificList(@PathVariable Long listId, @PathVariable int userId, Model model) {
        User user = userService.findById(userId);
        listService.addUserToSpecificList(listId, user);
        return "redirect:/"; // Przekierowanie do strony głównej po dodaniu użytkownika do listy
    }

}
