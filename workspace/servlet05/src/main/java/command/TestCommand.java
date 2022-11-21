package command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDAO;

public class TestCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 실제 비지니스 로직이 들어가는 부분
		// 컨트롤러 연결하고 다시 돌아옴.
		// DB에서 데이터를 조회해온다. DB연결 - > 조회메소드 호출
		// 조회해온 정보를 화면에서 출력할 수 있도록 request에 attribute로 데이터를 담는다.
		TestDAO dao = new TestDAO();
		Date today = dao.select_today();
		
		String now = dao.select_now();
		//현재시각 정보 조회 메소드 호출.
		
		int users = dao.user_count();
		
		//request 담음.
		//리퀘스트까지 담는걸 까먹음..
		request.setAttribute("today", today);
		request.setAttribute("now", now);
		request.setAttribute("users", users);
	}

}
