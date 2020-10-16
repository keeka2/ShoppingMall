package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.vo.ProductVO;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String p_key = request.getParameter("p_key");
		ProductVO[] p_list = (ProductVO[]) request.getSession().getAttribute("cur_list");
		for(int i=0;i<p_list.length;i++) {
			if(p_list[i].getP_key().equals(p_key)) {
				request.setAttribute("pvo", p_list[i]);
				break;
			}
		}
		return "/market/product_view.jsp";
	}

}
