package com.servlet.mime;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

public class MIMEServlet extends HttpServlet 
{
	@Override
		public void service(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException
	   {
		//read the query param value from the url
		String mimeType = req.getParameter("mimeType"); 
			  
        if(mimeType.equalsIgnoreCase("html"))
			//set MIME type as the html
			resp.setContentType("text/html");

		else if(mimeType.equalsIgnoreCase("excel"))
			//set MIME type as the xml
			resp.setContentType("application/vnd.ms-excel");

		else if(mimeType.equalsIgnoreCase("plain"))
			//set MIME type as the plain
			resp.setContentType("text/plain");

		else if(mimeType.equalsIgnoreCase("word"))
			//set MIME type as the word
			resp.setContentType("application/msword");

		else
			//set MIME type as the xml
			resp.setContentType("text/xml");

		//get the printWriter obj from resp obj
		PrintWriter pwObj	= resp.getWriter();
        
		//set the resonse to printWriter obj using print ln method
		pwObj.println("<table border='1' align='center'>");
		pwObj.println("<tr><th>R.No</th> <th>First Name</th> <th>Last Name</th> <th>Total Marks</th></tr>");
		pwObj.println("<tr><td>1</th> <th>Suresh</th> <th>Kanne</th> <th>550</th></tr>");
		pwObj.println("<tr><td>2</th> <th>Dheenesh</th> <th>Devara</th> <th>492</th></tr>");
		pwObj.println("<tr><td>3</th> <th>Amaresh</th> <th>Amaresh</th> <th>520</th></tr>");
		pwObj.println("<tr><td>4</th> <th>Mahesh</th> <th>Maha</th> <th>380</th></tr>");
		pwObj.println("<tr><td>5</th> <th>Navven</th> <th>Vattikudi</th> <th>410</th></tr>");
		pwObj.println("</table>");
	   }
}
