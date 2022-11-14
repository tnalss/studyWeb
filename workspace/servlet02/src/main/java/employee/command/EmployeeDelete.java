package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.hrDAO;

public class EmployeeDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		hrDAO dao = new hrDAO();
		
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.emp_force(id);
			dao.employee_fire(id);
		}
	}

}
