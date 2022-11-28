package hr.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.DepartmentDTO;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeList implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		HrDAO dao = new HrDAO();
		int department_id = -1;
		if (request.getParameter("department_id") != null) {
			department_id = Integer.parseInt(request.getParameter("department_id"));
		}

		// db에서 사원목록을 조회해옴
		List<EmployeeDTO> list = dao.employee_list(department_id);
		
		/*
		 *else가있기때문에 초기화 안해줘도됨!
		 * if (department_id == -1) { list = dao.employee_list(); } else { list =
		 * dao.employee_list(department_id); }
		 */
		
		// 부서목록도 조회해옴
		List<DepartmentDTO> departments = dao.department_list();

		// request에 담는다.
		request.setAttribute("list", list);
		request.setAttribute("departments", departments);
		
		// 선택한 부서 정보도 날려줘야함
		request.setAttribute("department_id", department_id);

	}

}
