package market.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Api_Action {
	String execute(HttpServletRequest request, HttpServletResponse response);
}
