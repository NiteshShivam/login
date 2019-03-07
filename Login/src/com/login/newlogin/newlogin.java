package com.login.newlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.loginDao;
@WebServlet("/loginnew")
public class newlogin extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
{
	String uname=request.getParameter("uname");
	String pass1 = request.getParameter("pass1");
	String pass2 = request.getParameter("pass2");
	if(pass1.equals(pass2))
	{
		 String query = "insert into login values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nitesh","root","And08141126");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,uname);
			ps.setString(2,pass1);
			ps.executeUpdate();
			loginDao dao = new loginDao();
			if(dao.checklogin(uname, pass1))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username",uname);
				response.sendRedirect("welcome.jsp");
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else
	{
		response.sendRedirect("newlogin.jsp");
	}
}
}
