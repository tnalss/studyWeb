package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

  
@WebServlet("*.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Hello Servlet: ").append(request.getContextPath());
		System.out.println("사용자가 웹브라우저에서 URL을 요청시 실행되는 곳");
		
		//응답하는 html문서를 만들어보자
		//쓰기작업 fileIO
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		writer.print("<!doctype html>");
		writer.print("<html>");
	
		writer.print("<body>");
		writer.print("<h2>hello!!!</h2>");
		writer.print("<div>응답 화면 만들기!</div>");
		writer.print("</body>");
		
		
		writer.print("</html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
