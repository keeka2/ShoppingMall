package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;

public class HomeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user==null) {
			return "/market/left.jsp";
		}else {
			request.setAttribute("name", user.getName());
			return "/market/left2.jsp?name="+user.getName();
		}
	}

}
