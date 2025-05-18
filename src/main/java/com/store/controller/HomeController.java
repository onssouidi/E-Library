package com.store.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.AttributedString;
import java.util.Locale;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Locale locale, Model model) {
        model.addAttribute("locale", locale);
        return "home";
    }
}
