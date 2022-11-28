package hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		
		EmployeeDTO dto = new EmployeeDTO();
		
		//파라미터에서 값 읽어와서 dto 넣어주기
		
		
		
		
		HrDAO dao = new HrDAO();
		dao.employee_update(dto);

	}

}
