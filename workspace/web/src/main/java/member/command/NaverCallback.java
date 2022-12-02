package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtility;
import member.MemberDAO;
import member.MemberDTO;

public class NaverCallback implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//callback 응답정보
		// 성공시 : 레퍼런스참고!
		// 실패시 :
		
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		//로그인 성공하면 code에 값이 있고 실패하면 null
		
		//세션에 넣어둔 state와 파라미터로 받은 state가 같은지 확인
		String session_state = request.getSession().getAttribute("state").toString();
		if(state.equals(session_state) && code!=null) {
			//접근토큰발급요청해야함
			//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
			//&client_id=jyvqXeaVOVmV
			//&client_secret=527300A0_COq1_XV33cf
			//&code=EIc5bFrl4RibFls1
			//&state=9kgsGTfH4j7IyAkg  

			StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
			url.append("&client_id=").append(request.getAttribute("naver_id").toString()); //문자열로 변환하는거 까먹기 쉬움
			url.append("&client_secret=").append(request.getAttribute("naver_secret").toString());
			url.append("&code=").append(code);
			url.append("&state=").append(state);
			
			// 레퍼런스에서 긁어온 try catch 가지고 commonutility로
			String tokens = CommonUtility.requestAPI(url.toString());
			//String을 JSON으로 다시 바꿔줘야함. 라이브러리 필요!!
			//json in java
			//https://mvnrepository.com/artifact/org.json/json/20220320
			JSONObject json = new JSONObject(tokens);
			String access = json.getString("access_token");
			String type = json.getString("token_type");
			
			// 접근토큰을 이용하여 프로필 api 호출하기!
			url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
			String profile = CommonUtility.requestAPI(url.toString(),type+" "+access);
			json = new JSONObject(profile);
			if(json.getString("resultcode").equals("00")) {
				// 소셜로그인인지 확인을 위한 컬럼 추가를 해줘야함 sqldeveloper실행
				//
				json = json.getJSONObject("response");
				MemberDTO dto = new MemberDTO();
				dto.setSocial("N");
				dto.setUserid(json.getString("id"));
				dto.setEmail(json.getString("email"));
				dto.setName(json.getString("name"));
				if(dto.getName().isEmpty()) {
					dto.setName(json.getString("nickname"));
				}
				
				dto.setGender(json.getString("gender").equals("F")?"여":"남");		
				// 생일은 더해서 하면됨	
				dto.setBirth(json.has("birthyear") ? json.getString("birthyear")+"-"+json.getString("birthday"):"");
				dto.setProfile(json.has("profile_image")? json.getString("profile_image"):"");
				dto.setPhone(json.getString("mobile"));
				
				//db에 해당 id가 존재하는지 파악
				MemberDAO dao = new MemberDAO();
				if( dao.idExist(dto.getUserid()) ==0 ) {
				// 네이버로 로그인이 처음인 경우 : insert
					dao.member_insert(dto);
					
				} else {
				
					dao.member_update(dto);
				// 네이버로 로그인한 적이 있는 경우 : update
				}
				
								
				request.getSession().setAttribute("loginInfo", dto);
				
				
			}
			
		}
		
		
	}

}
