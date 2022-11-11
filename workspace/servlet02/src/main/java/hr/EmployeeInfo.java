package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.hrDAO;
import dto.EmployeeDTO;

@WebServlet("/employee/emp_info")
public class EmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스 로직 : 선택한 사원정보를 DB에서 조회해온다.
		hrDAO dao = new hrDAO();
		//DB에서 선택한 사원정보를 조회해오는 메소드 호출
		int id = Integer.parseInt( request.getParameter("id"));
		EmployeeDTO dto = dao.employee_info(id);
		
		//응답화면 연결 
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='../'>홈으로</a></div>");
		out.print("<div><a href='emp_list'>사원목록</a></div>");
		out.print("</hr>");
		out.print("<h2>사원정보</h2>");
		out.print("<table border='1'>");
		out.printf("<tr><th>사번</th><td>%d</td><tr>",dto.getEmployee_id());
		out.printf("<tr><th>사원명</th><td>%s</td><tr>",dto.getName());
		out.printf("<tr><th>이메일</th><td>%s</td><tr>",dto.getEmail());
		out.printf("<tr><th>부서</th><td>%d</td><tr>",dto.getDepartment_id());
		out.printf("<tr><th>업무</th><td>%s</td><tr>",dto.getJob_id());
		out.printf("<tr><th>입사일자</th><td>%s</td><tr>",dto.getHire_date());
		out.printf("<tr><td colspan='2' style='text-align:center'><a href ='emp_fire?id=%d'>해고</a></td><tr>",dto.getEmployee_id());
		out.printf("<tr><td colspan='2' style='text-align:center'><a href ='emp_modify?id=%d'>수정</a></td><tr>",dto.getEmployee_id());
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");

	}

}
