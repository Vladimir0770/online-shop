package com.mycompany.onlineshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage() { return "home";}

    @GetMapping("/profile")
    public String accountPage() {return "profile";}

    @GetMapping("/admins")
    public String adminsPage() {return "admins";}
}
