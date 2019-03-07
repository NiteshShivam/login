package com.login;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.loginDao;
@WebServlet("/login")
public class login extends HttpServlet {

	public void service(HttpServletRequest req ,HttpServletResponse response) throws IOException
	{
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		loginDao d = new loginDao();
		try {
			if(d.checklogin(uname,pass)){
				HttpSession session = req.getSession();
				session.setAttribute("username",uname);
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				response.sendRedirect("loginpage.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
