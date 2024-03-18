package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.service.ChatService;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class RegisterController {
	private final UserService service;
	private final ChatService chatService;

	public RegisterController(UserService userService, ChatService chatService) {
		this.service = userService;
		this.chatService = chatService;
	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@PostMapping("/registerUser")
	public String processRegister(Users user) {
		List<Users> listOfUsers = service.findAll();

		for(Users userInList : listOfUsers) {
			if (user.getEmail().equals(userInList.getEmail())) {
				return "redirect:/register?errorMail";
			}
		}

		if (checkPassword(user.getPassword() ) && user.getPassword().length() >= 8) {


			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			user.setPassword(hashedPassword);
			List<Chat> listOfChats = new ArrayList<>();
			listOfChats.add(chatService.getById(1L));
			user.setChat(listOfChats);
			service.save(user);
			return "redirect:/login";
		}

		return "redirect:/register?error";
	}

	private boolean checkPassword(String passwordToCheck) {
		Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[,./#@_])(?=.*[A-Z])(?=.*\\d).+$");
		return passwordPattern.matcher(passwordToCheck).matches();
	}
}
