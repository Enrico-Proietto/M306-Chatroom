package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.security.SecurityConfig;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    private final UserService service;
    private final SecurityConfig securityConfig;
	private final SessionController sessionController;

	public LoginController(UserService service, SecurityConfig securityConfig, SessionController sessionController) {
		this.service = service;
		this.securityConfig = securityConfig;
		this.sessionController = sessionController;
	}

	@GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @GetMapping("/login?error")
    public String showLoginFormError(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("error");
        return "login";
    }

    @PostMapping("/loginUser")
    public String processLogin(Users user) {
        Users userFromDb = service.findByEmail(user.getEmail());
        PasswordEncoder passwordEncoder = securityConfig.passwordEncoder();

        if (userFromDb != null && passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            sessionController.setSession(userFromDb);
            return "redirect:/chat";
        }

        return "redirect:/login?error";
    }

}
