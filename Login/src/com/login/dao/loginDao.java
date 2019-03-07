package com.login.dao;
import java.sql.*;
public class loginDao {
String query ="select * from login where uname=? and pass=?";
public boolean checklogin(String uname,String pass) throws ClassNotFoundException, SQLException
{   Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nitesh","root","And08141126");
     PreparedStatement ps = con.prepareStatement(query);
     ps.setString(1, uname);
     ps.setString(2, pass);
     ResultSet rs = ps.executeQuery();
     if(rs.next())
    	 return true;
	return false;
	
}
}
