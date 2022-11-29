package hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.HrDAO;

public class EmployeeDelete implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt( request.getParameter("id") );
		HrDAO dao = new HrDAO();
		dao.employee_delete(id);
		
	}

}
