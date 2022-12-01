package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

public class CommonUtility {
	static public String appUrl(HttpServletRequest request) {
		// URL -  http://localhost/web/naverlogin.mb
		String url = request.getRequestURL().toString();
		//getrequest URI 아니고 URL임 주의!!@#!@#!@#
		// servletPath -  /naverlogin.mb
		String path = request.getServletPath();
		
		
		// http://localhost/web 이거를 어디서 가져오냐? url에서 servletpath를 빼면될듯?
		return url.replace(path,"");
	}
	
	static public String requestAPI(String apiURL) {
	    try {
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("GET");
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        System.out.print("responseCode="+responseCode);
	        if(responseCode==200) { // 정상 호출
	          br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
	          //한글이깨지지 않도록 utf-8 처리.
	        } else {  // 에러 발생
	          br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
	        }
	        String inputLine;
	        StringBuffer res = new StringBuffer();
	        while ((inputLine = br.readLine()) != null) {
	          res.append(inputLine);
	        }
	        br.close();
	        if(responseCode==200) {
	        	System.out.println(res.toString());
	        }
	        apiURL=res.toString();//재활용해서 담아줌
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	    return apiURL;
	}
	
	// 토큰으로 프로필호출하기 위해 메소드 오버로딩
	static public String requestAPI(String apiURL, String property) {
	    try {
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("GET");
	        
	        // 프로퍼티 추가해줘야함
	        con.setRequestProperty("Authorization", property);
	        //
	        
	        
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        System.out.print("responseCode="+responseCode);
	        if(responseCode==200) { // 정상 호출
	          br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
	          //한글이깨지지 않도록 utf-8 처리.
	        } else {  // 에러 발생
	          br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
	        }
	        String inputLine;
	        StringBuffer res = new StringBuffer();
	        while ((inputLine = br.readLine()) != null) {
	          res.append(inputLine);
	        }
	        br.close();
	        if(responseCode==200) {
	        	System.out.println(res.toString());
	        }
	        apiURL=res.toString();//재활용해서 담아줌
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	    return apiURL;
	}
}
