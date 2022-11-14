package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.hrDAO;
import dto.EmployeeDTO;

public class EmployeeInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//화면입력값을 db에 저장
		//1. 화면 입력한 사원정보를 수집
		EmployeeDTO dto = new EmployeeDTO();
		dto.setLast_name( request.getParameter("last_name") );
		dto.setFirst_name( request.getParameter("first_name") );
		dto.setEmail( request.getParameter("email") );
		dto.setJob_id(request.getParameter("job_id"));
		
		//문자열을 int로 변환해줄 필요
		dto.setDepartment_id( Integer.parseInt(request.getParameter("department_id")));
	
		dto.setSalary( Integer.parseInt( request.getParameter("salary") ) );
		
		//2. 수집한 정보를 DB저장 : db연결 -> 저장 처리 메소드
		
		hrDAO dao = new hrDAO();
		dao.employee_insert(dto);
		
	
	}

}
