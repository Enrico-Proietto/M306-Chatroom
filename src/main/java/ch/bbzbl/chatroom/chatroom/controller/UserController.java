package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.UserDTO;
import ch.bbzbl.chatroom.chatroom.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService;
	@Getter
	@Setter
	private UserDTO currentUser;

	@RequestMapping("user/getUser")
	public void getUser() {

	}

}
