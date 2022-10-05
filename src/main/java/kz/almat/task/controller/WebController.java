package kz.almat.task.controller;

import kz.almat.task.dto.CreateUserRequestDto;
import kz.almat.task.model.Users;
import kz.almat.task.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UsersService usersService;

    @GetMapping({"/index", "/"})
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute CreateUserRequestDto user) {
        usersService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        CreateUserRequestDto users = new CreateUserRequestDto();
        model.addAttribute("user", users);
        return "registration";
    }

}
