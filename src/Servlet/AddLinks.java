package Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JDBC.DaoClass;
import JDBC.Links;

public class AddLinks extends HttpServlet {


		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(true);// Servlet中  创建session对象
		DaoClass dao = new DaoClass();
		try {
			
			dao.addLinks(req.getParameter("LinkName"),req.getParameter("LinkA"),(String)session.getAttribute("Email") );
			//添加完成，跳转回mylinks
			RequestDispatcher reqd = req.getRequestDispatcher("jsp/MyLinks.jsp");
			reqd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
