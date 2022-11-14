package employee.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.hrDAO;
import dto.EmployeeDTO;

public class EmployeeUpdateInput implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		hrDAO dao = new hrDAO();

		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDTO dto = dao.employee_info(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<div><a href=''>홈으로</a></div>");
			out.print("<div><a href=''>사원목록</a></div>");
			out.print("</hr>");
			out.print("<h2>사원정보</h2>");

			out.print("<form action='emp_modi_query' method='post'>");
			out.print("<table border='1'>");
			out.printf("<tr><th>사번</th> <td><input type='text' value='%d' name='employee_id'/></td><tr>",
					dto.getEmployee_id());
			out.printf("<tr><th>사원이름</th><td><input type='text' value='%s' name='first_name'/></td><tr>",
					dto.getFirst_name());
			out.printf("<tr><th>사원성</th><td><input type='text' value='%s' name='last_name'/></td><tr>",
					dto.getLast_name());
			out.printf("<tr><th>이메일</th><td><input type='text' value='%s' name='email'/></td><tr>", dto.getEmail());
			out.printf("<tr><th>부서</th><td><input type='text' value='%d' name='department_id'/></td><tr>",
					dto.getDepartment_id());
			out.printf("<tr><th>업무</th><td><input type='text' value='%s' name='job_id'/></td><tr>", dto.getJob_id());
			out.printf("<tr><th>salary</th><td><input type='text' value='%d' name='salary'/></td><tr>",
					dto.getSalary());
			out.printf("<tr><th>입사일자</th><td><input type='text' value='%s' name='hire_date'/></td><tr>",
					dto.getHire_date());
			out.printf("<tr><td colspan='2' style='text-align:center'><a href ='emp_fire?id=%d'>해고</a></td><tr>",
					dto.getEmployee_id());
			out.printf("<tr><td colspan='2' style='text-align:center'><a href ='emp_modify?id=%d'>수정</a></td><tr>",
					dto.getEmployee_id());
			out.print("<tr><td colspan='2'><input type='submit' value='변경완료'/></td></tr>");
			out.print("</table>");

			out.print("</form>");

			out.print("</body>");
			out.print("</html>");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("who", dto);

	}

}
