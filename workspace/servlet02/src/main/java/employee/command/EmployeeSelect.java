package employee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.hrDAO;
import dto.EmployeeDTO;

public class EmployeeSelect implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//사원조회 커맨드 자바클래스
		//앞으로 비지니스 로직처리는 커맨드클래스가 한다.
		//필터랑 비슷한느낌인듯?
		
		hrDAO dao = new hrDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		
		//조회해온 데이터를 담아둘곳이 필요함
		// request에 담는다!
		request.setAttribute("list", list); //오브젝트라 list도 담을 수 있다!
		
		
	}

}
