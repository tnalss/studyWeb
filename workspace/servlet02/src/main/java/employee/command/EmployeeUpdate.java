package employee.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.hrDAO;
import dto.EmployeeDTO;

public class EmployeeUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		EmployeeDTO dto = (EmployeeDTO) request.getAttribute("who");
		
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
		
		
	}

}
