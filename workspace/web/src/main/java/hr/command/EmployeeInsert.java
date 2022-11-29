package hr.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeInsert implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		HrDAO dao = new HrDAO();
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone_number(request.getParameter("phone_number"));
		dto.setSalary(Integer.parseInt( request.getParameter("salary") ));
		dto.setDepartment_id(Integer.parseInt( request.getParameter("department_id")));
		dto.setJob_id(request.getParameter("job_id"));
		dto.setManager_id(Integer.parseInt( request.getParameter("manager_id")));
		dto.setHire_date( Date.valueOf(request.getParameter("hire_date")));
		
		dao.employee_regist(dto);
		
		
	}

}
