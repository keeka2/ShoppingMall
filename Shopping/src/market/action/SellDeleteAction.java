package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;

public class SellDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String p_key = request.getParameter("p_key");
		MemberDAO.delSell(p_key);
		return new ManagementAction().execute(request, response);
	}

}
