package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.util.Paging;
import mybatis.dao.ProductDAO;
import mybatis.vo.ProductVO;

public class ListAction implements Action {
	int blockList = 10;
	int blockPage = 5;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//페이징
		String page = request.getParameter("page");
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		Paging cur_page=null;
		ProductVO[] p_list=null;
		
		int rowTotal=0;
		int p = 1;
		if(page!=null) {
			p = Integer.parseInt(page);
		}
		if(search==null) {
			search="";
		}

		rowTotal = ProductDAO.getTotal(category,search);
		cur_page = new Paging(p,rowTotal, blockList, blockPage,category);
		p_list = ProductDAO.getList(category,search,cur_page.getBegin(),cur_page.getEnd());

		request.getSession().setAttribute("cur_list", p_list);
		request.setAttribute("p_list", p_list);
		request.setAttribute("page_html", cur_page.getSb().toString());
		return "/market/product_list.jsp";
	}

}
