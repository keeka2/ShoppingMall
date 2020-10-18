package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import mybatis.service.FactoryService;
import mybatis.vo.CartVO;
import mybatis.vo.MemberVO;
import mybatis.vo.ProductVO;

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
	
	public static CartVO[] getCartList(String user_key) {
		CartVO[] ret = null;
		SqlSession sql = FactoryService.getFactory().openSession();
		List<ProductVO> list;
		list = sql.selectList("member.myCart",user_key);
		if(list!=null && list.size()>0) {
			ret = new CartVO[list.size()];
			list.toArray(ret);
		}
		sql.close();
		return ret;
		
	}
	
	public static ProductVO[] getSellList(String user_key) {
		ProductVO[] ret = null;
		SqlSession sql = FactoryService.getFactory().openSession();
		List<ProductVO> list;
		list = sql.selectList("member.mySell",user_key);
		if(list!=null && list.size()>0) {
			ret = new ProductVO[list.size()];
			list.toArray(ret);
		}
		sql.close();
		return ret;
		
	}
	
	public static void delCart(String user_key,String p_key) {
		CartVO[] ret = null;
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_key",user_key);
		map.put("p_key",p_key);
		SqlSession sql = FactoryService.getFactory().openSession();
		int check = 0;
		if(p_key.equals("all")){
			check = sql.delete("member.delCartAll",map);
		} else {
			check = sql.delete("member.delCart",map);
		}
		if(check>0) {
			sql.commit();
		}else {
			sql.rollback();
		}
		sql.close();
	}
	
	public static void delSell(String p_key) {
		SqlSession sql = FactoryService.getFactory().openSession();
		int check = sql.delete("member.delSell",p_key);
		if(check>0) {
			sql.commit();
		}else {
			sql.rollback();
		}
		sql.close();
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
