package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.stereotype.Controller;

@Getter
@Controller
public class SessionController {

	private final HttpSession session;

	public SessionController(HttpSession session) {
		this.session = session;
	}

	public void setSession(Users user) {
		session.setAttribute("user", user);
	}
}
