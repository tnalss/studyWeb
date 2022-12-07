package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtility;
import member.MemberDTO;

public class MemberLogout implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("loginInfo");
		
		String social= dto.getSocial();
		
		request.getSession().removeAttribute("loginInfo");
		request.setAttribute("url", request.getContextPath());
	if( social!=null && social.equals("K") ){	
		//카카오 로그인의 경우만
		//https://kauth.kakao.com/oauth/logout
		//?client_id=${YOUR_REST_API_KEY}
		//&logout_redirect_uri=${YOUR_LOGOUT_REDIRECT_URI}
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/logout");
		url.append("?client_id=").append(request.getAttribute("kakao_id"));
		url.append("&logout_redirect_uri=").append(CommonUtility.appUrl(request));
	
		request.setAttribute("url", url.toString());
	}
		
	}

}
