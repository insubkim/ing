package mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping("login")
	public String loginController(HttpServletRequest req, HttpSession session, @RequestParam Map<String, String> param) {
		boolean rst =loginService.loinAccount(param);
		return "WEB-INF/view/ChatRoom";
	}
}
