package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerInfo implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		
		CustomerDAO dao = new CustomerDAO();
		int id = Integer.parseInt( request.getParameter("id"));
		CustomerDTO dto = dao.customer_info(id);
		request.setAttribute("dto", dto);
	}

}
