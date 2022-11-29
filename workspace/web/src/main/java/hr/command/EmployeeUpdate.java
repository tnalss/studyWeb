package hr.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		
		//파라미터에서 값 읽어와서 dto 넣어주기
	
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone_number(request.getParameter("phone_number"));
		dto.setSalary(Integer.parseInt( request.getParameter("salary") ));
		dto.setDepartment_id(Integer.parseInt( request.getParameter("department_id")));
		dto.setJob_id(request.getParameter("job_id"));
		dto.setManager_id(Integer.parseInt( request.getParameter("manager_id")));
		//날짜는 date.valueof로 넣어줌!!#@!@#!@!#@!@#@!
		dto.setHire_date( Date.valueOf(request.getParameter("hire_date")));
		
		
		HrDAO dao = new HrDAO();
		dao.employee_update(dto);

	}

}
