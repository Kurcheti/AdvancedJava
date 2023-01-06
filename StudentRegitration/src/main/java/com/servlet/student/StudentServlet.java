package com.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String STD_INSERT_QUERY ="INSERT INTO STUDENT (STD_ID, STD_FIRST_NAME, STD_LAST_NAME, STD_MOBILE_NO, STD_EMAIL_ID, "
				+ "STD_GENDER, STD_COURSE, STD_ADDRESS, STD_PASSWORD) VALUES (student_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		
				
		//read the form values
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String mobileNumber = req.getParameter("mobileNumber");
		String emailId = req.getParameter("emailId");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");
		String currentAddress = req.getParameter("currentAddress");
		String password = req.getParameter("password");
		
		//JDBC logic starts
			
		try {
			//1.load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. create Connection object
			Connection connectionObj = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","MYORA7AM","passsword");
			
			//3.create prepared statement
			if(connectionObj != null) {
			
			   PreparedStatement pstmtObj = connectionObj.prepareStatement(STD_INSERT_QUERY);
			   //set the form values to prepared statement obj
			   pstmtObj.setString(1, firstName);
			   pstmtObj.setString(2, lastName);
			   pstmtObj.setString(3, mobileNumber);
			   pstmtObj.setString(4, emailId);
			   
			   //preparing the gender as M or F or O
			   char charGender = '/';
			   if(gender.equalsIgnoreCase("Male"))
				   charGender = 'M';
			   else if(gender.equalsIgnoreCase("FeMale"))
				   charGender = 'F';
			   else 
				   charGender = 'O';
			
			   pstmtObj.setString(5, Character.toString(charGender));
			   pstmtObj.setString(6, course);
			   pstmtObj.setString(7, currentAddress);
			   pstmtObj.setString(8, password);
			   
			   if(pstmtObj != null) {
				   int count = pstmtObj.executeUpdate();
				   
				   if(count > 0) {
					   
					 //get the Writer
						PrintWriter pwObj = resp.getWriter();
						
						pwObj.println("<html>");
						pwObj.println("<body bgcolor= 'lightblue'>");
						pwObj.println("<h1>Student Registration Successfull with below details..</h1><br>");
						pwObj.println("<table border=1>");
						pwObj.println("<tr><td>First Name</td><td>"+firstName+"</td></tr>");
						pwObj.println("<tr><td>Last Name</td><td>"+lastName+"</td></tr>");
						pwObj.println("<tr><td>Mobile Number</td><td>"+mobileNumber+"</td></tr>");	
						pwObj.println("<tr><td>Gender</td><td>"+gender+"</td></tr>");
						pwObj.println("<tr><td>Course</td><td>"+course+"</td></tr>");
						pwObj.println("<tr><td>Current Address</td><td>"+currentAddress+"</td></tr>");
						pwObj.println("</table>");
						pwObj.println("</body>");
						pwObj.println("</html>");
						
						//close Writer obj
						pwObj.close();
				   }
				   
			   
			   }
				   
			}
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
