package market.action;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mybatis.dao.ProductDAO;
import mybatis.vo.MemberVO;
import mybatis.vo.ProductVO;

public class SellAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String viewPath = "/market/sellFormat.jsp";
		
		String content_Type = request.getContentType();
		if(content_Type != null && content_Type.startsWith("multipart")) {
			System.out.println("sell");
			// 파라미터 받아서 DB에 저장!!!!
			try {
				//첨부파일을 저장할 폴더를 절대경로화 시킨다.
				ServletContext application = request.getServletContext();
				MemberVO user = (MemberVO)request.getSession().getAttribute("user");
				String path = application.getRealPath("/upload");
				System.out.println(path);
				MultipartRequest mr = new MultipartRequest(request, path,1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
				//첨부된 파일이 bbs_upload라는 폴더로 업로드 된다.
				Enumeration files = mr.getFileNames();
				String p_thumbnail1 = (String)files.nextElement();
				String p_thumbnail2 = mr.getFilesystemName(p_thumbnail1);
				String p_image1 = (String)files.nextElement();
				String p_image2 =  mr.getFilesystemName(p_image1);
				
				//bbs테이블에 저장할 업로드된 파일명을 얻어야 한다.
				String p_name = mr.getParameter("p_name");
				String p_content = mr.getParameter("p_content");
				String p_price = mr.getParameter("p_price");
				String p_category = mr.getParameter("p_category");
				String p_quant = mr.getParameter("p_quant");
				String p_seller = user.getUser_key();
				String p_thumbnail = path+"/"+p_thumbnail2;
				String p_image = path+"/"+p_thumbnail2;
				
				ProductDAO.add(p_name, p_content, p_price, p_seller, p_category, p_quant, p_thumbnail, p_image);
			} catch (Exception e) {
				e.printStackTrace();
			}
			viewPath=null;
		}
		return viewPath;
	}
	
}
