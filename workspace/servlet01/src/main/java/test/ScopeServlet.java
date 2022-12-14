package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		/*
			jsp/servlet 에는 유효범위(scope)가 있다.
			1. application : 웹서버가 서비스 되는 동안 유효
			2. session : 세션이 유지되는 동안 유효
			새탭 -> 세션연결되어있음 브라우저를 모두 닫으면 세션이 종료
			3. request : 요청된 페이지와 응답하는 jsp/servlet 까지 유효
			4. page : JSP에서만 적용가능 해당 페이지에만 유효
			
			각 scope에 data를 담아두려면 attribute로 데이터를 담는다.
		*/
		//page < request < session < application


		ServletContext context = getServletContext();
		context.setAttribute("app", "Application Scope Data");
		//app이라는 이름에 application Scope Data를 저장했음
		
		HttpSession session = request.getSession();
		session.setAttribute("session", "Session Scope Data");
		
		request.setAttribute("request", "Request Scope Data");
		request.setAttribute("no", 123);
		
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("</body>");
		out.print("<h2>Scope 정보</h2>");
		
		
		out.printf("<div>Request :  %s </div>",request.getAttribute("request"));
		
		//object -> integer
		out.printf("<div>Request :  %d </div>", (Integer) request.getAttribute("no"));
		
		
		out.printf("<div>Session :  %s </div>",session.getAttribute("session"));
		out.printf("<div>Application :  %s </div>", context.getAttribute("app"));
		
		out.print("</body>");
		out.print("</html>");
		
	}

}
