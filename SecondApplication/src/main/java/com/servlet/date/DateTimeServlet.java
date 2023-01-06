package com.servlet.date;//package statement

import java.util.Date;//importing Date
import java.io.PrintWriter;//importing PrintWriter
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.GenericServlet;
public class DateTimeServlet extends GenericServlet
{
	@Override
		public void service(ServletRequest req, ServletResponse resp)throws ServletException,IOException{
			
			//Get the PrintWriter object from resp obj
			PrintWriter printWriterObj = resp.getWriter();
				
			//request processing logic
			Date dateObj = new Date();

			//write generated date output to respnse object by using printWriter obj println method
			printWriterObj.println("Hello.. Today Date and Time is :  "+dateObj);

			//close printStream obj
			printWriterObj.close();
			
		}
	

}  
