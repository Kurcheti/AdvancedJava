package com.servlet.mime;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

public class WordServlet extends HttpServlet 
{
	@Override
		public void service(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException
	   {
		//set MIME type to the resp object
		resp.setContentType("application/msword");

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
