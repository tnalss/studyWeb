package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.hrDAO;
import dto.EmployeeDTO;

@WebServlet("/employee/emp_list")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		
		out.print("<div><a href='../'>홈으로</a></div>");
		out.print("<div><a href='index.html'>사원관리</a></div>");
		out.print("<hr>");
		out.print("<h2>사원목록</h2>");
		out.print("<table border='1'>");
		out.print("<tr><th>사번</th><th>사원명</th><th>부서명</th><th>급여</th>"
				+ "<th>입사일자</th></tr>");
		
		hrDAO dao = new hrDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		
		for (EmployeeDTO dto : list) {
			
			out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>"
					,dto.getEmployee_id() , dto.getName() 
					,dto.getDepartment_name(), dto.getSalary() , dto.getHire_date());
			
			
		}
	
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	
	
	}

}
