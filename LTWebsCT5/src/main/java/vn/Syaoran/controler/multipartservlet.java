package vn.Syaoran.controler;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.Syaoran.dao.impl.UserDaoImpl;
import vn.Syaoran.models.UserModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static vn.Syaoran.Ultis.Constant.UPLOAD_DIRECTORY;
import static vn.Syaoran.Ultis.Constant.DEFAULT_FILENAME;



@WebServlet(name = "MultiPartServlet",urlPatterns = {"/multiPartServlet"})

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class multipartservlet extends HttpServlet {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	UserDaoImpl userDao = new UserDaoImpl();
	String pathimage;
	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return DEFAULT_FILENAME;
	}

	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 HttpSession session1 = req.getSession();
			if (session1 != null && session1.getAttribute("account") != null) {
				UserModel u = (UserModel) session1.getAttribute("account");
				
//				String uploadPath = File.separator + UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ
				String uploadPath = UPLOAD_DIRECTORY;
				 //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào thư mục project
				 File uploadDir = new File(uploadPath);
				 if (!uploadDir.exists())
					 uploadDir.mkdir();
				 try {
					 String fileName = "";
					 for (Part part : req.getParts()) {
						fileName = getFileName(part);
						part.write(uploadPath + File.separator + fileName);
					 }
//					 req.setAttribute("message", "File " + fileName + " has uploaded successfully!");
					 pathimage = uploadPath+ "\\"+fileName ;
				 	}
				 catch (FileNotFoundException fne) {
					 req.setAttribute("message", "There was an error: " + fne.getMessage());
				 }
				
				String username = u.getUserName();
				String fullname = req.getParameter("fullname");
				String phone = req.getParameter("phone");
				String image = pathimage;
				UserModel user=userDao.updateprofile(username, fullname, phone, image);
				if(user!=null) {
					req.setAttribute("message", "Profile update completed!");
					
					session1.removeAttribute("account");
					HttpSession session = req.getSession(true);
					session.setAttribute("account", user);
					
					req.getRequestDispatcher("/views/Update.jsp").forward(req, resp);
//					getServletContext().getRequestDispatcher("/views/Multipart.jsp").forward(req, resp);
					return;
				}
				req.setAttribute("message", "Upload failed");
				req.getRequestDispatcher("/views/Update.jsp").forward(req, resp);
				return;
				
			} else {
				resp.sendRedirect(req.getContextPath() + "/Login");
			}
		 }
}
