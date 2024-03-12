package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.stereotype.Controller;

@Controller
public class SessionController {

	@Getter
	private HttpSession session;

	public void setSession(Users user) {
		session.setAttribute("user", user);
	}
}
