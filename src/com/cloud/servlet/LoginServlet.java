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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {

       
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PreparedStatement ps = null;
            ResultSet rs = null;
            ResultSet rs1 = null;
            try 
            {
               ps = con.prepareStatement("select username, password from admin where username='" + username + "' and password='" + password + "'");
               rs = ps.executeQuery();
                if (rs != null) 
                {
                    boolean checkNext = rs.next();
                    if (checkNext == true) 
                    {
                        
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/operator.jsp");
                        rd.include(request, response);
                    } 
                    else 
                    {
                    	PrintWriter out= response.getWriter();
	  					out.println("<font color=red>"+"Invalid Username or Password "+"</font>");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                        rd.include(request, response);
                    }
                } 
                else 
                {
                	PrintWriter out= response.getWriter();
					  out.println("<font color=red>"+"Please enter something"+"</font>");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                    rd.include(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("Database connection problem");
                throw new ServletException("DB Connection problem.");
            } finally {
                try {
                    if (rs1 != null) {
                        rs1.close();
                    }
                    rs.close();
                    ps.close();
                } catch (SQLException e) {
                    logger.error("SQLException in closing PreparedStatement or ResultSet");;
                }

            }
            }
}

