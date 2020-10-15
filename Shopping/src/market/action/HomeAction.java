package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;

public class HomeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String viewPath = "/market/home.jsp";
		String content_Type = request.getContentType();
		if(content_Type != null && content_Type.startsWith("application")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println(id+" "+pw);
			MemberVO user = MemberDAO.login(id, pw);
			System.out.println(user.getEmail());
			if(user!=null) {
				request.setAttribute("user", user);
				viewPath="/market/shop.jsp";
			}
		}
		return viewPath;
	}

}
