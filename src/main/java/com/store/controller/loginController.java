package com.store.controller;
import com.store.models.UserModel;
import com.store.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class LoginController {
    private final UsersService usersService;
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "register";
    }
    @GetMapping("/login")
    String getLoginPage(Model model) {
        model.addAttribute("loginRequest",new UserModel());
        return "login";
    }
    @PostMapping("/register")
    String register(@ModelAttribute UserModel usermodel) {
        System.out.println("register request"+usermodel);
        UserModel registeredUser=usersService.registerUser(usermodel.getLogin(),usermodel.getPassword(),usermodel.getEmail());
        return registeredUser ==null ? "error": "redirect:/login" ;
    }
    @PostMapping("/login")
    String login(@ModelAttribute UserModel usermodel) {
        System.out.println("login request"+usermodel);
        UserModel authenticatedUser=usersService.authenticateUser(usermodel.getLogin(),usermodel.getPassword());
        if (authenticatedUser != null) {
            return "redirect:/books";
        }
        else{return "error_page";}
    }

}