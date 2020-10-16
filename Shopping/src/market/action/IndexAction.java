package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.vo.MemberVO;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		
//		if(user==null) {
//			return "/market/index.jsp?status=fail";
//		}else {
//			return "/market/index.jsp?status=success";
//		}
		return "/market/index.jsp";
	}

}
