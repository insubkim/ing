package mvc.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	SqlSessionTemplate template;
	
	public  boolean loinAccount( Map<String, String> param){
		return template.selectOne("account.SelectAccount", param);
	}
}
