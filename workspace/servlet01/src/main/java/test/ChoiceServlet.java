package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/choice")
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gender = request.getParameter("gender");
		//String sports = request.getParameter("sports");
		//같은 파라미터명으로 여러개의 데이터가 전송된 경우.
		String[] sports = request.getParameterValues("sports");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>선택한 정보들</h2>");
		out.printf("<div>성별 : %s </div>",gender);
		//out.printf("<div>스포츠 : %s </div>",sports);
		out.printf("<div>스포츠 : ");
		
		for (String string : sports) {
			out.printf("%s &nbsp;",string);
			
		}
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	
	}

}
