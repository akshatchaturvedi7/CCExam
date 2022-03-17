import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Salary_Details")
public class Salary_Details extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid=request.getParameter("empid");
		String job=request.getParameter("job");
		String msal=request.getParameter("msal");
		String bonus=request.getParameter("bonus");
		
		
		Insert_salary obj = new Insert_salary();
		if(obj.insert(empid, job, msal, bonus)) {
			response.sendRedirect("Login.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
	}
}
