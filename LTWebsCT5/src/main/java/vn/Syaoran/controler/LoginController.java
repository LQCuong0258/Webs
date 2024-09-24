package vn.Syaoran.controler;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.Syaoran.models.UserModel;
import vn.Syaoran.services.impl.UserService;


@WebServlet(urlPatterns = { "/login" })
public class Logincontroller extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService service = new UserService();
	
	@SuppressWarnings("null")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null&&session.getAttribute("account") == null) {
			req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
		}
		else
			resp.sendRedirect(req.getContextPath() + "/home");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html");

				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String remember = req.getParameter("remember");

				String alertMsg = "";
				boolean isRememberMe = false;
				if ("on".equals(remember)) {
					isRememberMe = true;
				}
				if (username.isEmpty() || password.isEmpty()) {
					alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
					return;
				}
				UserModel user = service.login(username, password);
				if (user != null) {
					
					HttpSession session = req.getSession(true);
					session.removeAttribute("account");
					session.setAttribute("account", user);
					if (isRememberMe) {
						saveRemeberMe(resp, username);
					}
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				} else {
					alertMsg = "Username or password incorrect";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);

				}
	}
	
	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(vn.Syaoran.Ultis.Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

}
