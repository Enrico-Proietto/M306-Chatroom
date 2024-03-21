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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Controller
public class ChatMessageController {

	private final SessionController sessionController;
	private final UserService userService;
	private final MessageService messageService;
	private final ChatService chatService;

	public ChatMessageController(SessionController sessionController, UserService userService, MessageService messageService, ChatService chatService) {
		this.sessionController = sessionController;
		this.userService = userService;
		this.messageService = messageService;
		this.chatService = chatService;
	}

	@GetMapping("/chat/messages")
	@ResponseBody
	public List<Message> getChatMessagesTest(@Nullable Long chatID) {
		HttpSession session = sessionController.getSession();
		Object userID = session.getAttribute("userId");
		Users user = userService.getById((Long) userID);
		if (user != null && chatID != null) {
			return messageService.findMessageByChatId(chatID);

		}

		throw new InvalidRequestStateException("Not logged in");
	}

	@PostMapping("/chat/newMessage")
	public ModelAndView newMessage(Message message) {
		HttpSession session = sessionController.getSession();
		Long chatID = (Long) session.getAttribute("chatID");
		if (session.getAttribute("userId") != null && chatID != null) {
			Object userID = sessionController.getSession().getAttribute("userId");
			Users user = userService.getById((Long) userID);
			Chat chat = chatService.getById(chatID);

			Date dateToTransform = new Date();
			LocalDateTime time = dateToTransform.toInstant()
							.atZone(ZoneId.systemDefault())
							.toLocalDateTime()
							.truncatedTo(ChronoUnit.MINUTES);

			message.setWrittenAt(time);
			message.setAuthor(user);
			message.setChat(chat);
			messageService.save(message);
		}
		return new ModelAndView("redirect:/chat?chatID=" + chatID);
	}
}
