package mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import mybatis.service.FactoryService;
import mybatis.vo.MemberVO;

public class MemberDAO {
	public static boolean register(String id,String pw,String name,String addr,String phone,String email) {
		SqlSession sql = FactoryService.getFactory().openSession();
		Map map = makeMap(id,pw,name,addr,phone,email);
		int c = sql.insert("member.register", map);
		boolean value=false;
		if(c>0) {
			sql.commit();
			value=true;
		}else {
			sql.rollback();
		}
		sql.close();
		return value;
	}
	public static MemberVO login(String id, String pw) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("pw",pw);
		SqlSession sql = FactoryService.getFactory().openSession();
		MemberVO user = sql.selectOne("member.login",map);
		System.out.println(user.getEmail());
		sql.close();
		return user;
	}

	
	public static HashMap<String,String> makeMap(String id,String pw,String name,String addr,String phone,String email){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("pw",pw);
		map.put("name",name);
		map.put("addr",addr);
		map.put("phone",phone);
		map.put("email",email);
		return map;
	}
}
