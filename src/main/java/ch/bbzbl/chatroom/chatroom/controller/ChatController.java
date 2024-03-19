package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import ch.bbzbl.chatroom.chatroom.model.message.Message;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.service.ChatService;
import ch.bbzbl.chatroom.chatroom.service.MessageService;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.servlet.http.HttpSession;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Objects;

@Controller
@RequestMapping
public class ChatController {

	private final SessionController sessionController;
	private final UserService userService;
	private final ChatService chatService;
	private final MessageService messageService;

	public ChatController(SessionController sessionController, UserService userService, ChatService chatService, MessageService messageService) {
		this.sessionController = sessionController;
		this.userService = userService;
		this.chatService = chatService;
		this.messageService = messageService;
	}

	@GetMapping("/chat")
	public String showChat(@Nullable Long chatID, Model model) {
		HttpSession session = sessionController.getSession();
		Object userID = session.getAttribute("userId");
		Users user = userService.getById((Long) userID);

		if (user != null) {
			if (chatID != null) {
				for (Chat chat : user.getChat()) {
					if (Objects.equals(chat.getId(), chatID)) {
						session.setAttribute("chatID", chatID);
						session.setAttribute("user-username", user.getFirstname() + " " + user.getLastname());
						model.addAttribute("newMessage", new Message());
						model.addAttribute("messages", messageService.findMessageByChatId(chatID));
					}
				}
			}

			model.addAttribute("chatrooms", user.getChat());

			return "chat";

		}

		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		sessionController.setSessionInvalid();
		return "redirect:/login";
	}
}
