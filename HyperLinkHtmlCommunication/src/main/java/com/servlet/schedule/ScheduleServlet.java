package com.servlet.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the Print Writer
		PrintWriter pwObj = resp.getWriter();
		
		//set the MIME type
		resp.setContentType("text/html");
		
		//Get the current time
		LocalDateTime localDateTimeObj = LocalDateTime.now();
		int hour = localDateTimeObj.getHour();
		
		//set the background color of the page
		pwObj.println("<html>");
		pwObj.println("<body bgcolor='pink'>");
		pwObj.println("<h1 style='color:green;text-align:center'>"+localDateTimeObj.toString()+"</h1>");
		if(hour>=6 && hour<=7 )
			pwObj.println("<h2 style='color:orange;text-align:center'>Your current Schedule is Brushing & Freshup</h2>");
		else if(hour>=7 && hour<=9 )
			pwObj.println("<h2 style='color:red;text-align:center'>Your current Schedule is Adv Java Session</h2>");
		else if(hour>=9 && hour<=10 )
			pwObj.println("<h2 style='color:yellow;text-align:center'>Your current Schedule is BreakFast</h2>");
		else if(hour>=10 && hour<=22 )
			pwObj.println("<h2 style='color:yellow;text-align:center'>Your current Schedule is Office Work</h2>");
		else
			pwObj.println("<h2 style='color:white;text-align:center'>Your current Schedule is Sleeping</h2>");
		pwObj.println("</body>");
		pwObj.println("</html>");
		
		//close the printWriter
		pwObj.close();
		
	}

}
