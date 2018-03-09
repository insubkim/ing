package mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.service.AccountService;


@Controller
public class IndexController {
	@RequestMapping("")
	public String IndexControl(){
		return "/WEB-INF/view/index.jsp";
	}
	@RequestMapping("newAccount")
	public String NewAccountControl(@RequestParam Map<String, String> param){
		boolean rst =AccountService.addAccount(param);
		return "/WEB-INF/view/newAccountResult.jsp";
	}

}
