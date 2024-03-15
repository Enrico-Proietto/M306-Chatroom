package ch.bbzbl.chatroom.chatroom.controller;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

import java.util.Objects;

@Controller
public class ReroutingController {
	private final SessionController sessionController;

	public ReroutingController(SessionController sessionController) {
		this.sessionController = sessionController;
	}

	@GetMapping("/")
	public String defaultForm() {
		HttpSession session = sessionController.getSession();
		Object user = session.getAttribute("userId");

		if (user != null) {
			return "redirect:/chat";
		}
		return "redirect:/login";
	}

	@GetMapping("/admin")
	public String getAdmin(Model model) {
		return "admin";
	}
}
