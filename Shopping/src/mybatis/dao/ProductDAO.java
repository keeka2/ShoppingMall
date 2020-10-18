package mybatis.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;


public class ProductDAO {
	String p_key, p_name,p_content,p_price,p_seller,p_category,p_quant,p_thumbnail,p_image,p_date;

	public static void add(String p_name, String p_content, String p_price, String p_seller, String p_category,String p_quant, String p_thumbnail, String p_image) {
		SqlSession sql = FactoryService.getFactory().openSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("p_name",p_name);
		map.put("p_content",p_content);
		map.put("p_price",p_price);
		map.put("p_category",p_category);
		map.put("p_quant",p_quant);
		map.put("p_seller",p_seller);
		map.put("p_thumbnail",p_thumbnail);
		map.put("p_image",p_image);
		int check = sql.insert("shop.add", map);
		if(check>0) {
			sql.commit();
		}else {
			sql.rollback();
		}
	}
	
	public static ProductVO[] getList(String category, String search, int begin, int end) {
		ProductVO[] ret = null;
		SqlSession sql = FactoryService.getFactory().openSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("begin",String.valueOf(begin));
		map.put("end",String.valueOf(end));
		map.put("search",search);
		List<ProductVO> list;
		if(category.equals("all")) {
			list = sql.selectList("shop.list_all",map);
		}else {
			map.put("p_category",category);
			list = sql.selectList("shop.list", map);
		}
		if(list!=null && list.size()>0) {
			ret = new ProductVO[list.size()];
			list.toArray(ret);
		}
		sql.close();
		return ret;
	}
	
//	public static int getTotal(String category) {
//		String ret = "0";
//		SqlSession sql = FactoryService.getFactory().openSession();
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("p_category",category);
//		if(category.equals("all")) {
//			ret = sql.selectOne("shop.getTotal");
//		}else {
//			ret = sql.selectOne("shop.getcTotal", map);
//		}
//		System.out.println(ret);
//		return Integer.parseInt(ret);
//	}
	
	public static int getTotal(String category,String search) {
		String ret = "0";
		SqlSession sql = FactoryService.getFactory().openSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("p_category",category);
		map.put("search",search);
		if(category.equals("all")) {
			ret = sql.selectOne("shop.getTotal",map);
		}else {
			ret = sql.selectOne("shop.getcTotal", map);
		}
		System.out.println(ret);
		return Integer.parseInt(ret);
	}

}
