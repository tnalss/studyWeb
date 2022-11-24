package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.command.CustomerInfo;
import customer.command.CustomerList;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command=null;
		String uri = request.getServletPath();
		boolean redirect = false;
		String view="";
		//고객목록화면 요청시
		if(uri.equals("/list.cu")) {
			
			//비지니스
			command = new CustomerList();
			command.exec(request, response);
			
			//응답화면
			view = "customer/list.jsp";
		} else if ( uri.equals("/info.cu")) {
			//비지니스
			command = new CustomerInfo();
			command.exec(request, response);
			//응답화면
			view = "customer/info.jsp";
		}
		
		// 화면연결 기본은 forward , redirect는 true인 경우
		// redirect : db에 insert, update,delete 하는 비지니스로직
		// forward : select
		if(redirect) {
			response.sendRedirect(view);
		}else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
