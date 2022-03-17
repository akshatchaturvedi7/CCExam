

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid=request.getParameter("Employee_ID_Number");
		String pwd=request.getParameter("Password");
		String fname=request.getParameter("FirstName");
		String lname=request.getParameter("LastName");
		String dob=request.getParameter("Date_of_Birth");
		String contact =request.getParameter("Contact_Number");
		
		
		Insert_record obj = new Insert_record();
		if(obj.insert(empid, pwd, fname, lname, dob, contact)) {
			response.sendRedirect("Salary_det.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
		
	}

	

}
