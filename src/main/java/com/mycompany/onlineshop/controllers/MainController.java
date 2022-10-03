package com.mycompany.onlineshop.controllers;

import com.mycompany.onlineshop.entities.User;
import com.mycompany.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() { return "home_page/index";}

    @GetMapping("/profile")
    public String accountPage(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", user);
        return "profile";
    }

    @GetMapping("/admins")
    public String adminsPage() {return "admins";}
}
