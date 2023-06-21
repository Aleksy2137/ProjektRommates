package com.example.rommates.controller;
import com.example.rommates.service.ListService;
import com.example.rommates.model.UserList; // Zmieniłem nazwę klasy na RoommateList
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class ListController {
    @Autowired
    private ListService listService;
    @GetMapping("/user/{userId}/lists")
    public String viewLists(@PathVariable int userId, Model model) {
        List<UserList> lists = listService.findByUserId(userId);
        model.addAttribute("lists", lists);
        return "lists";
    }
    @PostMapping("/user/{userId}/lists/add")
    public String addList(@PathVariable int userId) {
        listService.addList(userId);
        return "redirect:/user/" + userId + "/lists";
    }
    @PostMapping("/list/{listId}/add")
    public String addUserToList(@PathVariable int listId, @RequestParam int userId) {
        listService.addUserToList(listId, userId);
        return "redirect:/list/" + listId;
    }
// Add more methods as needed...
}
