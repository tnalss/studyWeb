package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.command.CustomerDelete;
import customer.command.CustomerInfo;
import customer.command.CustomerInsert;
import customer.command.CustomerList;
import customer.command.CustomerUpdate;

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
		} else if ( uri.equals("/modify.cu")) {
			//고객정보수정화면 요청
			//비지니스 로직
			command = new CustomerInfo();
			command.exec(request, response);
					
			//응답화면
			view="customer/modify.jsp";
		} else if ( uri.equals("/update.cu")) {
			//고객 정보 수정 저장처리 요청
			command = new CustomerUpdate();
			command.exec(request, response);
			//응답화면 연결
			//view="customer/info.jsp";
			view="info.cu?id="+request.getParameter("id");
			redirect= true;
			// 성별이 좁아서 못들어가는데??????????
			//필터가없어서!@#!@#
		} else if ( uri.equals("/new.cu")) {
			
			//응답화면
			view="customer/new.jsp";
			
		} else if ( uri.equals("/insert.cu")) {
			//비지니스 로직
			command = new CustomerInsert();
			command.exec(request, response);
			
			
			//응답화면 연결
			view="list.cu";
			//u , i ,d 는 redirect!@#!@#!@#!@#!@#
			redirect=true;
		}else if ( uri.equals("/delete.cu")) {
			
			command = new CustomerDelete();
			command.exec(request, response);
			
			//응답화면
			view="list.cu";
			redirect=true;
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
