package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.command.EmployeeDelete;
import employee.command.EmployeeInsert;
import employee.command.EmployeeSelect;
import employee.command.EmployeeUpdate;
import employee.command.EmployeeUpdateInput;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	http://localhost/servlet02/select.do
		String uri = request.getRequestURI();//포트번호뒤에서부터 파악해서 문자열로 반환해주는 메소드 (/servelet02/select.do)
		String context = request.getContextPath(); //(/servlet02)이부분
		// 빼거나 길이다음부터 출력하던가.
		uri = uri.substring( context.length() );  // (/select.do) 이 부분

		String business = "",view="";
		
		if ( uri.equals("/select.do") ) {
					
			business = "조회 요청에 대한 비지니스 로직";
			view = "select";//"조회 요청에 대한 응답화면";
			
			//커맨드를 만들었으니 이제
			//커맨드를 활용할차례
			EmployeeSelect command = new EmployeeSelect();
			command.execute(request, response); // 이것까지 적어주면 컨트롤러 일은 끝났음 커맨드에 연결시켜줬으니!
			
			// 응답할 화면까지도 연결해주자. 리퀘스트에 담아서 가져왔음.
			RequestDispatcher rd = request.getRequestDispatcher(view); //응답할화면의 이름을 view에저장
			rd.forward(request, response);
			
		} else if (uri.equals("/insert.do")) {
			business = "저장 요청에 대한 비지니스 로직";
			view = "select.do";
			
			//비지니스로직
			EmployeeInsert command = new EmployeeInsert();
			command.execute(request, response);
			
			
			//응답화면 연결 insert, delete, update 처리가 실행되는 요청후 화면 연결은 redirect로 해주자.
			response.sendRedirect(view);
			
			
		} else if (uri.equals("/update.do")) {
			business = "수정 요청에 대한 비지니스 로직";
			view = "select.do";			
			
			EmployeeUpdateInput command = new EmployeeUpdateInput();
			command.execute(request, response);
			
			
			response.sendRedirect(view);
			
			
		} else if (uri.equals("/delete.do")) {
			business = "삭제 요청에 대한 비지니스 로직";
			view = "select.do";		
			
			EmployeeDelete command = new EmployeeDelete();
			command.execute(request, response);
			
			response.sendRedirect(view);
			
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.print("<div><a href='front.html'>frontcontroller패턴</a></div>");
		out.print("<hr>");
		out.printf("<div>%s</div>", business);
		out.printf("<div>%s</div>", view);
		
		out.print("</body></html>");
	}

}
