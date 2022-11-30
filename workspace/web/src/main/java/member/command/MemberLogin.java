package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import member.MemberDAO;
import member.MemberDTO;

public class MemberLogin implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// 화면에서 입력한 아이디와 비밀번호가 일치하는 회원정보를 조회 한다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.login(id, pw);
		
		// 화면에서 출력할 수 있도록 데이터를 attribute로 담는다.
		request.getSession().setAttribute("loginInfo", dto);
		
		// 쓰기작업으로 응답
		try {
			response.getWriter().print(dto == null ? false : true );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		};
	}

}
