package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.service.ChatService;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class ChatController {

    private final SessionController sessionController;
    private final UserService userService;
    private final ChatService service;

    public ChatController(SessionController sessionController, UserService userService, ChatService service) {
        this.sessionController = sessionController;
        this.userService = userService;
        this.service = service;
    }

    @GetMapping("/chat")
    public String showChat(Model model) {
        HttpSession session = sessionController.getSession();
        Object userID = session.getAttribute("userId");
        Users user = userService.getById((Long) userID);
        model.addAttribute("chatrooms", user.getChat());
        return "chat";
    }

    @GetMapping("/createChat")
    public String showChatForm(Model model) {
        HttpSession session = sessionController.getSession();
        Object userID = session.getAttribute("userId");
        if (userID != null) {
            List<Users> availableUsers = userService.findAll();

            model.addAttribute("availableUsers", availableUsers);
            model.addAttribute("chat", new Chat());
            return "createChat";
        }
        return "redirect:/login";
    }

    @PostMapping("/create")
    public String processCreateChat(Chat chat) {

        HttpSession session = sessionController.getSession();
        Object userID = session.getAttribute("userId");


        Long userIdLong = (Long) userID;
        Users creator = userService.getById(userIdLong);

        chat.setCreator(creator);
        chat.setCreationDate(new Date());


        service.save(chat);

        List<Chat> list = creator.getChat();
        list.add(chat);
        creator.setChat(list);
        userService.save(creator);



        return "redirect:/chat";
    }
    @GetMapping("/chatrooms")
    public void getChatRooms(Model model) {

    }



}
