package vn.Syaoran.controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.Syaoran.dao.impl.UserDaoImpl;
import vn.Syaoran.models.UserModel;


@WebServlet(urlPatterns = { "/SignUp" })
public class Signupcontroller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String cfpsw= req.getParameter("confirm-password");
//		String roleidstr = req.getParameter("roleid");
//		int roleid = Integer.parseInt(roleidstr);
		
		String alertMsg = "";
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		if (!password.equals(cfpsw)) {
			alertMsg = "Password not matched!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/SignUp.jsp").forward(req, resp);
			return;
		}
		
		
		if (userDao.CheckUserExist(username) == true) {
			alertMsg = "Username exist!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/SignUp.jsp").forward(req, resp);
			return;

		}

		if (userDao.CheckEmailExist(email) == true) {
			alertMsg = "Email exist!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/SignUp.jsp").forward(req, resp);
			return;
		}

		userDao.insert(new UserModel(null,username,email,password,null, null,3, null));
		req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
