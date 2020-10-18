package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;
import mybatis.vo.CartVO;
import mybatis.vo.MemberVO;
import mybatis.vo.ProductVO;

public class ManagementAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		String user_key = user.getUser_key();
		ProductVO[] sellList = MemberDAO.getSellList(user_key);
		int Total=0;
		System.out.println(sellList[0].getP_name());
		if(sellList!=null) {
			request.setAttribute("cartList", sellList);
			return "/market/management.jsp";
		}else {
			return null;
		}
	}

}
