package hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeInfo implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		HrDAO dao = new HrDAO();
		int id = Integer.parseInt( request.getParameter("id"));
		EmployeeDTO dto = dao.employee_info(id);
		
		request.setAttribute("dto", dto);
	}

}
