package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

public class UserInfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터에서 아이디 긁어옴.
		String id = request.getParameter("id");
		//선택한 사용자의 정보를 DB에서 조회해온다.
		UserDAO dao = new UserDAO();
		//사용자의 정보조회 메소드 -> 조회할때 아이디를 같이 던져주자.
		UserDTO dto = dao.select_user_info(id);
		

		// 화면에 출력할 수 있도록 request에 attribute로 담는다.
		request.setAttribute("dto", dto);

	}

}
