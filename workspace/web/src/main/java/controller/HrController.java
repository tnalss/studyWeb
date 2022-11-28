package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.command.EmployeeInfo;
import hr.command.EmployeeList;


@WebServlet("*.hr")
public class HrController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view ="";
		Command cmd = null;
		boolean redirect = false;
		
		if( uri.equals("/list.hr")) {
			request.getSession().setAttribute("category","hr");
			//비지니스
			cmd = new EmployeeList();
			cmd.exec(request, response);
			//응답
			view="employee/list.jsp";
			
		}else if( uri.equals("/info.hr")) {
			cmd = new EmployeeInfo();
			cmd.exec(request, response);
			view="employee/info.jsp";
			
		} else if (uri.equals("/modify.hr")) {
			view = "employee/modify.jsp";
		}
		

		if(redirect)
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
		
	}

}
