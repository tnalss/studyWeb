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
		hrDAO dao = new hrDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		
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
				+ "<th>입사일자</th><th>해고</th><th>정보수정</th></tr>");
		
		for (EmployeeDTO dto : list) {
			
			out.printf("<tr><td><a href='emp_info?id=%d'>%d</a></td><td>%s</td><td>%s</td><td>%d</td><td>%s</td>"
					+ "<td><a href='emp_fire?id=%d'>해고</a></td><td><a href='emp_modify?id=%d'>수정</a></td></tr>"
					,dto.getEmployee_id(),dto.getEmployee_id() , dto.getName() 
					,dto.getDepartment_name(), dto.getSalary() , dto.getHire_date(),dto.getEmployee_id(),dto.getEmployee_id());
			
			
		}
	
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	
	
	}

}
