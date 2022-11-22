package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list = dao.product_list();
		
		request.setAttribute("list", list);
		
	}

}
