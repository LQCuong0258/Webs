package vn.Syaoran.controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.Syaoran.Ultis.Constant;


@WebServlet(urlPatterns = { "/logout" })
public class Logoutcontroller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lấy session hiện tại (không tạo mới nếu không có)
		HttpSession session = req.getSession(false);


		
		
		session.removeAttribute("account");
		// Remove remember me cookie if it exists
				Cookie[] cookies = req.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
							cookie.setMaxAge(0); // delete the cookie
							resp.addCookie(cookie); // add the deleted cookie to the response
							break;
						}
					}
				}
				// Redirect to login page or home page after logout
			resp.sendRedirect(req.getContextPath() + "/login");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
