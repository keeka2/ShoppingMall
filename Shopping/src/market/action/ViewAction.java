package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.ShopDAO;
import mybatis.vo.MemberVO;
import mybatis.vo.ProductVO;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String p_key = request.getParameter("p_key");
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		String cur_p = (String)request.getSession().getAttribute("cur_p");
		
		if(user==null) {
			request.setAttribute("status", "false");
		}else {
			request.setAttribute("status", "true");
		}
		if(p_key==null) {
			p_key = cur_p;
		}else if(cur_p==null) {
			request.getSession().setAttribute("cur_p",p_key);
		}else if(!cur_p.equals(p_key)) {
			request.getSession().setAttribute("cur_p",p_key);
		}
		
		ProductVO[] p_list = (ProductVO[]) request.getSession().getAttribute("cur_list");
		
		for(int i=0;i<p_list.length;i++) {
			if(p_list[i].getP_key().equals(p_key)) {
				ShopDAO.click(p_key,p_list[i].getP_quant());
				request.setAttribute("pvo", p_list[i]);
				break;
			}
		}
		return "/market/product_view.jsp";
	}

}
