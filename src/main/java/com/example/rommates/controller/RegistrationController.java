package com.example.rommates.controller;

import com.example.rommates.model.User;
import com.example.rommates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    public String registerUser(@RequestParam String login,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String city,
                               @RequestParam Integer age,
                               @RequestParam Integer academicYear,
                               @RequestParam String priceRange,
                               @RequestParam String shortDescription,
                               @RequestParam String longDescription,
                               @RequestParam String contactInformation) {
        System.out.println("Registering user: " + login); // log
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setCity(city);
        user.setAge(age);
        user.setAcademicYear(academicYear);
        user.setPriceRange(priceRange);
        user.setShortDescription(shortDescription);
        user.setLongDescription(longDescription);
        user.setContactInformation(contactInformation);
        userService.save(user); // Zapisz użytkownika do bazy danych

        return "redirect:/login"; // Przekieruj do strony logowania po rejestracji
    }

}


