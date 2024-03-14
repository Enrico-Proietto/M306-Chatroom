package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ChatController {

    private final SessionController sessionController;
    private final UserService userService;

    public ChatController(SessionController sessionController, UserService userService) {
        this.sessionController = sessionController;
        this.userService = userService;
    }

    @GetMapping("/chat")
    public String showChat(Model model) {
        HttpSession session = sessionController.getSession();
        Object userID = session.getAttribute("userId");
        Users user = userService.getById((Long) userID);
        model.addAttribute("chatrooms", user.getChat());
        return "chat";
    }

    @GetMapping("/chatrooms")
    public void getChatRooms(Model model) {

    }
}
