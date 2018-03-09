package mvc.service;

import java.util.Map;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {

	@Autowired
	SqlSessionTemplate template;
	
	public  boolean addAccount( Map<String, String> param){
		System.out.println(param.toString());
		param.put("id", param.get("id"));
		param.put("pw", param.get("pw"));
		param.put("email", param.get("email"));
		return template.insert("account.addAccount", param) == 1;
	}
}
