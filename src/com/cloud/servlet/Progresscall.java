package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Progresscall")
public class Progresscall extends HttpServlet {
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
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/progress.jsp");
			  
				
				
            rd.include(request, response);
		}
        
        else{
        
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
          PreparedStatement ps = null;
          ResultSet rs = null;
          PrintWriter out= response.getWriter();
             try {
            	  
				ps = con.prepareStatement("select * from addcall where status='" + uname + "'");
				
				  rs = ps.executeQuery();
				  if (rs != null) 
	                {
					  out.println("<table border=1 width=50% height=50%>");
                      out.println("<tr><th>Caller Name</th><th>Caller no.</th><th>Operator assigned</th><th>Status<//th><tr>");
                      while (rs.next()) {
                          String n = rs.getString("name");
                          String nm = rs.getString("cnum");
                          String nmo = rs.getString("operator");
                          String nmop = rs.getString("status"); 
                          out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + nmo + "</td><td>" + nmop +"</th></tr>"); 
                      }
                      out.println("</table>");
                      out.println("</html></body>"); out.println("<h1>"+"Caller Name: "+rs.getString(1)+"</h1>"+
                  	"<h1>"+"Caller No.: "+rs.getString(2)+"</h1>"
                  	 +"<h1>"+"Operator assigned: "+rs.getString(4)+"</h1>"
                  	 +"<h1>"+"Call Status: "+rs.getString(5)+"</h1>"+"<br>");
                  	 
                                    
	                     
	                    	                     
	                    	 
	                    	 
	                  
	                    }
	                    else{ 
	  					  
	  					
	  					  out.println("<font color=red>"+"Invalid Username or Password "+"</font>");
	  					  RequestDispatcher rd = getServletContext().getRequestDispatcher("/progress.jsp");
	  					  
	  						
	  						
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
