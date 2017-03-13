package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.DaoClass;

public class Update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//接收前台参数
		System.out.println(req.getParameter("LinkId")+req.getParameter("LinkName")+req.getParameter("LinkA"));
		//调用数据库updateLinks()方法
		DaoClass dao = new DaoClass();
		try {
			dao.updateLinks(req.getParameter("LinkId"), req.getParameter("LinkName"), req.getParameter("LinkA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转发回到MyLinks
		RequestDispatcher reqd = req.getRequestDispatcher("jsp/MyLinks.jsp");
		reqd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
