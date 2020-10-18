package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;
import mybatis.vo.CartVO;
import mybatis.vo.MemberVO;
import mybatis.vo.ProductVO;

public class MyCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		String user_key = user.getUser_key();
		CartVO[] cartList = MemberDAO.getCartList(user_key);
		int Total=0;
		if(cartList!=null) {
			for(CartVO vo : cartList) {
				vo.setTotalPrice(vo.getCount()*Integer.parseInt(vo.getP_price()));
				Total+=vo.getTotalPrice();
			}
			request.setAttribute("cartList", cartList);
			request.setAttribute("Total", Total);
			return "/market/cartList.jsp";
		}else {
			return null;
		}
	}

}
