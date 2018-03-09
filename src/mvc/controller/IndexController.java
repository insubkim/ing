package mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	@RequestMapping("")
	public String IndexControl(){
		return "/WEB-INF/view/index.jsp";
	}
}
