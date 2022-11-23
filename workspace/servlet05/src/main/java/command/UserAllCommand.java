package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

public class UserAllCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//DB에서 전체 사용자 이름을 조회해온다.
		UserDAO dao = new UserDAO();
		
		List<String> list = dao.select_name_all();
		//화면에 출력할 수 있도록 조회결과를 request에 담아준다.
		request.setAttribute("list", list);
		
		//이거 다하면 dto도 해보자.
		List<UserDTO> user_list = dao.select_user_list();
		request.setAttribute("user_list", user_list);
		//다하면 전체상품목록 출력 해보기
	}

}
