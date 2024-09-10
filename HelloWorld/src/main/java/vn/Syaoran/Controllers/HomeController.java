package vn.Syaoran.Controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/home", "/trangchu"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 3275831982104841568L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String varLastName = req.getParameter("LastName");
		String varFirstName = req.getParameter("FirstName");
		
		// Đưa dữ liệu ra view
		req.setAttribute("fname", varFirstName);
		req.setAttribute("lname", varLastName);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/Login.jsp");
		rd.forward(req, resp);
		
//		PrintWriter printW = resp.getWriter();
//		printW.println(varLastName + " " + varFirstName);
//
//		printW.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
