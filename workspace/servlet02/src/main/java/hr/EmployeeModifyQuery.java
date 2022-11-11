package hr;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.hrDAO;
import dto.EmployeeDTO;

@WebServlet("/employee/emp_modi_query")
public class EmployeeModifyQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력정보 수집
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id( Integer.parseInt( request.getParameter("employee_id") ));
		dto.setLast_name( request.getParameter("last_name") );
		dto.setFirst_name( request.getParameter("first_name") );
		dto.setEmail( request.getParameter("email") );
		dto.setJob_id( request.getParameter("job_id") );
		dto.setDepartment_id( Integer.parseInt(request.getParameter("department_id")) );
		dto.setSalary( Integer.valueOf( request.getParameter("salary") ));
		dto.setHire_date( Date.valueOf( request.getParameter("hire_date")));
		
		hrDAO dao = new hrDAO();
		dao.employee_modify(dto);
		
		response.sendRedirect("emp_list");
		
	}

}
