package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;

public class CustomerDelete implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		CustomerDAO dao = new CustomerDAO();
		int id = Integer.parseInt( request.getParameter("id"));
		dao.customer_delete(id);
	}
}
