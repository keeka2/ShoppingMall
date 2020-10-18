package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;

public class ShopDAO {
	
	public static void addCart(String user_key,String p_key) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("p_key",p_key);
		map.put("user_key",user_key);
		SqlSession sql = FactoryService.getFactory().openSession();
		int check = sql.insert("shop.addCart",map);
		if(check>0) {
			sql.commit();
		}else {
			sql.rollback();
		}
		
	}
	
	public static void click(String p_key,String p_quant) {
		SqlSession sql = FactoryService.getFactory().openSession();
		int cur = Integer.parseInt(p_quant);
		Map<String,String> map = new HashMap<String,String>();
		map.put("p_key",p_key);
		map.put("p_quant",Integer.toString(cur+1));
		
		int check = sql.update("shop.updateClick", map);
		
		if(check>0) {
			sql.commit();
		}else {
			sql.rollback();
		}
	}
}










