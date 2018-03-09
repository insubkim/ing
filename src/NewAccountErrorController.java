

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Controller;
@Controller
public class NewAccountErrorController {
	public String errorPage(JoinPoint cut, Exception e) {
		System.out.println("e"+cut.toString() + "/ " + e);
		
	//	model.addAttribute("error", e);
		return "/WEB-INF/view/AccountError.jsp?error="+e.getMessage();
	}
}
