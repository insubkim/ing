package mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.service.AccountService;


@Controller
public class NewAccountController {
	@Autowired
	AccountService accountService;

	@RequestMapping("newAccount")
	public String NewAccountControl(@RequestParam Map<String, String> param, Model model) {
		boolean rst = accountService.addAccount(param);
		model.addAttribute("result", rst);
		return "/WEB-INF/view/ChatRoom.jsp";
	}
}
