package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.TestCommand;

@WebServlet("*.do")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		uri = uri.substring( context.length() );
		
		String view ="";
		
		if(uri.equals("/test.do")) {
			//비지니스 로직
			TestCommand command = new TestCommand();
			command.execute(request, response);
			
			//응답화면 연결 : forward를 주로 쓰지만,
			// redirect하는경우 : db에 insert,update,delete하는 요청시에는 redirect
			view="test.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
