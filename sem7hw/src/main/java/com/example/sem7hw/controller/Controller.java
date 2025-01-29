package com.example.sem7hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller {

    @GetMapping("/private-data")
    @ResponseBody
    public String privateData() {
        return "Admin only";
    }

    @GetMapping("/public-data")
    @ResponseBody
    public String publicData() {
        return "Authenticated users only";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Вернёт login.html
    }
}
