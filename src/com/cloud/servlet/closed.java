package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/closed")
public class closed extends HttpServlet {
	public class Retrive extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
	        PrintWriter out =response.getWriter();
	        String uname = request.getParameter("status");
	        
			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
	          PreparedStatement ps = null;
	          ResultSet rs = null;
	         
	             try {
	            	  
					ps = con.prepareStatement("select * from addcall where status='" + uname + "'");
					
					  rs = ps.executeQuery();
					  while(rs.next())
					  {
						  out.println("<h1>"+rs.getString(5)+"</h1>");
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
		        
		}
		private HttpServletResponse setContentType(String string) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	}
