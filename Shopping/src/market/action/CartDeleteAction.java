package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;

public class CartDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String p_key = request.getParameter("p_key");
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		String user_key = user.getUser_key();
		System.out.println(p_key);
		MemberDAO.delCart(user_key, p_key);
		return new MyCartAction().execute(request,response);
	}

}
