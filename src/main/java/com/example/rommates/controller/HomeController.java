package com.example.rommates.controller;
import com.example.rommates.service.UserService;
import com.example.rommates.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cities", Arrays.asList("Paris", "London", "Amsterdam", "Cracow"));
        return "index";
    }
    @PostMapping("/search")
    public String search(@RequestParam String city, Model model) {
        List<User> users = userService.findByCity(city); // Upewnij się, że metoda findByCity istnieje w UserService
        model.addAttribute("users", users);
        return "search";
    }
}

