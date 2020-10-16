package market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.util.Paging;
import mybatis.dao.ProductDAO;
import mybatis.vo.ProductVO;

public class ListAction implements Action {
	private String category;
	int blockList = 10;
	int blockPage = 5;
	
	public ListAction(String category){
		this.category=category;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//페이징
		String page = request.getParameter("page");
		int rowTotal = ProductDAO.getTotal(category);
		int p = 1;
		if(page!=null) {
			p = Integer.parseInt(page);
		}
		Paging cur_page = new Paging(p,rowTotal, blockList, blockPage,category);
		ProductVO[] p_list = ProductDAO.getList(category,cur_page.getBegin(),cur_page.getEnd());
		System.out.println(cur_page.getBegin()+" "+cur_page.getEnd());
		request.getSession().setAttribute("cur_list", p_list);
		request.setAttribute("p_list", p_list);
		request.setAttribute("page_html", cur_page.getSb().toString());
		return "/market/product_list.jsp";
	}

}
