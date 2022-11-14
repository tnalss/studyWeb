package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
		//request.setCharacterEncoding("utf-8");

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.valueOf(request.getParameter("num2"));

		String operator = request.getParameter("operator");
		
		// 비지니스 로직
		Calculator c = new Calculator(num1,num2,operator);
		String result = num1+operator+num2+" = "+c.getResult();
		
		//응답화면에서 사용할 수 있도록 request에 담는다.
		request.setAttribute("calculated", result);
		
		//redirect에서는 값을 불러올 수 없으니까 세션에 값을 담아보자.
		request.getSession().setAttribute("result", result);
		
		} catch (Exception e) {
//			RequestDispatcher rd = request.getRequestDispatcher("calculator_error");
//			rd.forward(request, response);
			
			request.setAttribute("error", e);
			//에러를 담아보내주자
			request.getRequestDispatcher("caculator_error").forward(request, response);
		}
		
		// 응답화면
		/*
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>계산결과</h2>");
		out.printf("%d %s %d = %d",num1,operator,num2,c.getResult());
		out.print("<div><a href=calculator.html>계산기화면</a></div>");
		out.print("</body>");
		out.print("</html>");
*/
		//1.forward 방식 -> 요청url이 그대로 유지됨
		/*
		RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
		rd.forward(request, response);
		*/
		//2. redirect 방식 -> 요청url은 redirect된 url로 변경됨
		//response.sendRedirect("hello.jsp");
		
		
		//1. forward 연결
		//RequestDispatcher rd = request.getRequestDispatcher("calculator_forward");
		//rd.forward(request, response);
		
		//2.redirect 연결
		
		
		//response.sendRedirect("calculator_redirect");
		
	}

}
