package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemberDAO;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String viewPath = "/market/register.jsp";
		String content_Type = request.getContentType();
		//System.out.println(content_Type);
		if(content_Type != null && content_Type.startsWith("application")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			System.out.println(id+" "+email);
			boolean check = MemberDAO.register(id, pw, name, addr, phone, email);
			if(check) {
				viewPath=null;
			}
		}
		return viewPath;
	}

}
