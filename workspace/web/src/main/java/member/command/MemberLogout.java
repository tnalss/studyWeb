package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class MemberLogout implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("loginInfo");
		request.setAttribute("url", request.getContextPath());
	}

}
