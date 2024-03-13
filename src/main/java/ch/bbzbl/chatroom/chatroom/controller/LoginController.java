package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserService service;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserController userController;
    private SessionController sessionController;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping
    public String processLogin(Users user) {
        Users userFromDb = service.findByEmail(user.getEmail());

        if (bCryptPasswordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            sessionController.setSession(user);
            return "redirect:/chat";
        }

        return "redirect:/login?error";
    }

}
