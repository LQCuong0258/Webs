package vn.Syaoran.controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.Syaoran.dao.impl.UserDaoImpl;
import vn.Syaoran.models.UserModel;


@WebServlet(urlPatterns = { "/Forgot" })
public class Forgotcontroller extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		UserModel user= userDao.findByUsername(username);
		if (user!=null) {
			if (user.getEmail().equals(email)&&user.getUserName().equals(username)) {
				
				HttpSession session = req.getSession(true);
				session.setAttribute("account1", user);
				req.getRequestDispatcher("/views/ChangePW.jsp").forward(req, resp);
				return;
			}
			else {
				String alertMsg = "username and email not matched!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/Forgot.jsp").forward(req, resp);
				return;
			}
		}
		else {
			String alertMsg = "Not exist username";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/Forgot.jsp").forward(req, resp);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
