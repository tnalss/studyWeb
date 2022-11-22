package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.ProductCommand;
import command.UserAllCommand;
import command.UserCommand;

@WebServlet("*.ju")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		uri = uri.substring( context.length() );
		
		String view ="";
		if(uri.equals("/user.ju")) {
			//비지니스
			UserCommand command = new UserCommand();
			command.execute(request, response);
		
			//응답
			view="user.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} else if(uri.equals("/userAll.ju")) {
			//비지니스
			Command command = new UserAllCommand();//다형성에 의해 Command로도 호출가능
			command.execute(request, response);//다만 상속한 메소드만 사용가능!
			
			//응답
			view="user_all.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		}else if(uri.equals("/productList.ju")) {
			//비지니스
			Command command = new ProductCommand();//다형성에 의해 Command로도 호출가능
			command.execute(request, response);//다만 상속한 메소드만 사용가능!
			
			//응답
			view="product_list.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		
	}

}
