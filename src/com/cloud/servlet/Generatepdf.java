package com.cloud.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/Generatepdf")
public class Generatepdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/pdf");
		OutputStream out=response.getOutputStream();
		try{
			Document document = new Document();
			String name="by heera baba";
			PdfWriter.getInstance(document,out);
			
			document.open();
			document.add(new Paragraph("Programmingshifts is an online tutorial."));
			document.add(new Paragraph("This report PDF created using Servlet ."));
			document.add(new Paragraph(name));
	         document.close();
		}
		catch(DocumentException exc)
		{
			throw new IOException(exc.getMessage());
	
		}
		finally
		{out.close();}
	}
	

}
