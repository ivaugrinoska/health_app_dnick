package com.example.health_app_dnick.web;
import com.example.health_app_dnick.model.enumerations.Role;
import com.example.health_app_dnick.model.exceptions.InvalidArgumentsException;
import com.example.health_app_dnick.model.exceptions.PasswordsDoNotMatchException;
import com.example.health_app_dnick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam Role role) {
        try{
            this.userService.register(username, password, repeatedPassword, name, surname, role);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
