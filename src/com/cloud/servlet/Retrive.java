package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Retrive")
public class Retrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
     
        String uname = request.getParameter("status");
        

        String errorMsg = null;
        if (uname == null || uname.equals("")) 
        {
            errorMsg = "Status required";
           
            
        } 
        String msg = "";
        
        if(errorMsg != null){
			
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/closedcall.jsp");
			  
				
				
            rd.include(request, response);
		}
        
        else{
        
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
          PreparedStatement ps = null;
          ResultSet rs = null;
          PrintWriter out= response.getWriter();
          out.println("<html><body>");
          try {
            	  
				ps = con.prepareStatement("select * from addcall where status='" + uname + "'");
				
				  rs = ps.executeQuery();
				  if (rs.getString("status").equals("pending")) { 
  					  
			        	out.println("<table border=1 width=50% height=50%>");
                      out.println("<tr><th>Caller Name</th><th>Caller no.</th><th>Operator assigned</th><th>Status<//th><tr>");
                      
                      while (rs.next()) {
                          String n = rs.getString("name");
                          String nm = rs.getString("cnum");
                          String nmo = rs.getString("operator");
                          String nmop = rs.getString("status"); 
                          out.println("<td>" + n + "</td><td>" + nm + "</td><td>" + nmo + "</td><td>" + nmop +"</th></tr>"); 
                      }
                      out.println("</table>");
                      out.println("</html></body>");
                      
	  					
  					  
  	                } 
				  else 
				  {
					 
					  out.println("<font color=red>"+"Invalid Username or Password "+"</font>");
  					  RequestDispatcher rd = getServletContext().getRequestDispatcher("/closedcall.jsp");
  			             rd.include(request, response);
	                }
				  
	  				  }
          
             
				  
			        
				  
	                
				  
	                    
	                
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
           
        }

	private HttpServletResponse setContentType(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
