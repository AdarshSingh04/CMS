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

/**
 * Servlet implementation class newcall
 */
@WebServlet("/newcall")
public class newcall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("name");
		String no = request.getParameter("cnum");
		String type = request.getParameter("status");
		String op = request.getParameter("operator");
		
		
		
String errorMsg = null;
		
		if(cname == null || cname.equals("")){
			errorMsg = "Caller name can't be left blank.";
		}
		if(no== null || no.equals("")){
			errorMsg = "Caller number can't be left blank.";
		}
		if(type == null || type.equals("")){
			errorMsg = "Type can't be left blank.";
		}
		if(op == null || op.equals("")){
			errorMsg = "Please specify the operator";
		}
	
		
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/newcall.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}
		
		else{
		
		
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps;
		try 
		{
			ps = con.prepareStatement("insert into addcall(name,cnum,status,operator) values (?,?,?,?)");
			ps.setString(1, cname);
			ps.setString(2, no);
			ps.setString(3, type);
			ps.setString(4, op);
	
			ps.execute();
		} catch (SQLException e) 
		{
			System.out.println("record not inserted");
		}
		
		
			//forward to login page to login
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/operator.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=green>Registration successful</font>");
			rd.include(request, response);
	}
	}

}
