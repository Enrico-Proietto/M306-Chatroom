package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.User;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UserService service;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String processLogin(User user) {
        User userFromDb = service.findByEmail(user.getEmail());

        if (userFromDb != null) {
            bCryptPasswordEncoder.matches(user.getPassword(), userFromDb.getPassword());
            return "redirect:/chat";
        }

        return "redirect:/login";
    }
}
