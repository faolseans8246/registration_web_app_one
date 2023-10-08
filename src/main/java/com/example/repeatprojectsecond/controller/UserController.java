package com.example.repeatprojectsecond.controller;


import com.example.repeatprojectsecond.service.UserService;
import com.example.repeatprojectsecond.tables.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


//    @GetMapping("/")
//    public String viewHome(Model model) {
//        model.addAttribute("rootPage", userService.getAllItems());
//        return "home";
//    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("rootPage", userService.getAllItems());
        return findWithPage(1,"firstname", "asc", model);
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

    @GetMapping("/updateItems/{id}")
    public String shoUpdatePage (@PathVariable (value = "id") long id, Model model){
        Users usersId = userService.getUserById(id);

        model.addAttribute("userTable", usersId);
        return "update_page";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUserNyId(@PathVariable (value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findWithPage (@PathVariable (value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortField") String sortDir, Model model) {
        int pageSize = 5;

        Page <Users> pageObj = userService.frindPaginated(pageNo, pageSize, sortField, sortDir);
        List<Users> listUsers = pageObj.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", pageObj.getTotalPages());
        model.addAttribute("totalItems", pageObj.getTotalElements());
//        model.addAttribute("listUsers", listUsers);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDr", sortDir.equals("asc") ? "desc" : "asc");


        return "home";

    }

}
