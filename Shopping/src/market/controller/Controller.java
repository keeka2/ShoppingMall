package market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.action.Action;
import market.action.HomeAction;
import market.action.LoginAction;
import market.action.RegisterAction;
import market.action.SellAction;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		Action action = null;
		if(type==null || type.equals("home")) {
			action = new HomeAction();
		}else if(type.equals("register")) {
			action = new RegisterAction();
		}else if(type.equals("login")) {
			action = new LoginAction();
		}else if(type.equals("sell")) {
			action = new SellAction();
		}
		
		String viewPath = action.execute(request,response);
		if(viewPath!=null) {
			RequestDispatcher disp = request.getRequestDispatcher(viewPath);
			disp.forward(request, response);
		}else {
			response.sendRedirect("Controller");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
