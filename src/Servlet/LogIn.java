package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import JDBC.DaoClass;
import JDBC.User;

public class LogIn extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoClass dao = new DaoClass();
		
			System.out.println("!!!test!!!");
		
		User user = new User();
		user.setEmail(req.getParameter("text_Email"));
		user.setPassWord(req.getParameter("text_PassWord"));
		
		try {
			String name =dao.queryUser(user);
			if(name != ""){
				System.out.println("ok");
				HttpSession session=req.getSession(true);// Servlet中  创建session对象
				session.setAttribute("UserName", name);
				session.setAttribute("Email", user.getEmail());
				req.setAttribute("Email", user.getEmail());//替换为session
				
				//带参数（session，arrlist） 跳转
				RequestDispatcher reqd = req.getRequestDispatcher("jsp/MyLinks.jsp");
				reqd.forward(req, resp);
			}
			else {
				//登录失败
				req.setAttribute("erro", "此邮箱或密码有误，请重试");
				req.setAttribute("goto", "html/LogIn.html");
				RequestDispatcher reqd = req.getRequestDispatcher("jsp/Erro.jsp");
				reqd.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
