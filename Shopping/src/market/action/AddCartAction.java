package market.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.ShopDAO;
import mybatis.vo.MemberVO;

public class AddCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String p_key = request.getParameter("p_key");
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		String user_key = user.getUser_key();
		ShopDAO.addCart(user_key, p_key);
		
		return new ViewAction().execute(request,response);
	}

}
