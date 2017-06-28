package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet(name = "signupServlet", urlPatterns = { "/signupServlet" })
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(RegisterServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String loc = request.getParameter("location");
		String mob = request.getParameter("mobile");
		String username= request.getParameter("username");
		String pw = request.getParameter("password");
		String errorMsg = null;
		
		if(fname == null || fname.equals("")){
			errorMsg = "first name can't be left blank.";
		}
		if(lname == null || lname.equals("")){
			errorMsg = "Last name can't be left blank.";
		}
		if(loc == null || loc.equals("")){
			errorMsg = "LOcation can't be left blank.";
		}
		if(mob == null || mob.equals("")){
			errorMsg = "Mobile can't be left blank.";
		}
		if(username == null || username.equals("")){
			errorMsg = "Username can't be left blank.";
		}
		if(pw == null || pw.equals("")){
			errorMsg = "password can't be left blank.";
		}
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}else{
		
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into admin(firstname,lastname,location,mobile,username,password) values (?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, loc);
			ps.setString(4, mob);
			ps.setString(5, username);
			ps.setString(6, pw);
			ps.execute();
			
			logger.info("User registered with username="+username);
	
			//forward to login page to login
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=green>Registration successful, please login below.</font>");
			rd.include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("DB Connection problem.");
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
		}
		
	}

}
