package mvc.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {

	@Autowired
	SqlSessionTemplate template;
	
	public  boolean addAccount( Map<String, String> param){
		return template.insert("account.addAccount", param) == 1;
	}
}
