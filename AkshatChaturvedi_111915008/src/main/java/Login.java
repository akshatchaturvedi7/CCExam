import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Login_Auth dao = new Login_Auth();
		String emp_id=request.getParameter("Employee_ID_Number");
		String pwd=request.getParameter("Password");
		if(dao.check(emp_id,pwd))
		{
//			HttpSession session = request.getSession();
//			session.setAttribute("username",uname);
			response.sendRedirect("Record.jsp");

		}
		else
		{
			response.sendRedirect("Login.jsp");

		}

	}
}
