package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.UserDTO;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user" )
public class UserController {

    private UserService userService;

    public UserDTO getUser() {
        return null;
    }
    @GetMapping("/login")
    public void login() {

    }
}
