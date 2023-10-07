package com.example.repeatprojectsecond.controller;


import com.example.repeatprojectsecond.service.UserService;
import com.example.repeatprojectsecond.tables.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("rootPage", userService.getAllItems());
        return "home";
    }


    @GetMapping("/showAddPage")
    public String addPage(Model model) {
        Users users = new Users();
        model.addAttribute("userTable", users);

        return "adduser";
    }

    @PostMapping("/saveUser")
    public String saveUsers(@ModelAttribute("userTable") Users users) {
        userService.saveUser(users);
        return "redirect:/";
    }

}
