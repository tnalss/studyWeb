package hr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.hrDAO;


@WebServlet("/employee/emp_fire")
public class EmployeeFire extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hrDAO dao = new hrDAO();
		
		int id = Integer.parseInt( request.getParameter("id"));
		dao.employee_fire(id);
		
		response.sendRedirect("emp_list");
	}

}
