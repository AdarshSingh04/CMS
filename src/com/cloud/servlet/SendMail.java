package com.cloud.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.cloud.servlet.SendingMail;  
  
  
@WebServlet(name = "SendingMail", urlPatterns = { "/SendingMail" })  
public class SendMail extends HttpServlet {  
public void doGet(HttpServletRequest request,  
 HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    
    String to=request.getParameter("to");  
    String subject=request.getParameter("subject");  
    String msg=request.getParameter("msg");  
          
    SendingMail.send(to, subject, msg);  {
    
    PrintWriter out = response.getWriter();  
    out.print("message has been sent successfully");  
    out.close();
    }
    }  
  
}  