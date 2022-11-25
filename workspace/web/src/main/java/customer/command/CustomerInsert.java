package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerInsert implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		CustomerDAO dao = new CustomerDAO();
		CustomerDTO dto = new CustomerDTO();
		
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		
		dao.customer_insert(dto);
		
		
	}

}
