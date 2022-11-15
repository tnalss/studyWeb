<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

//세션에 저장한 로그인정보인 아이디를 확인하자.
//object-> String으로 바꿔줘야지 다운캐스팅
String id = (String) session.getAttribute("id");
if(id==null){
	
	out.print("<div><a href = 'member/join.jsp'>회원가입</a></div>");
	out.print("<div><a href = 'member/login.jsp'>로그인</a></div>");
	//로그인을 해야함
}else{
	//로그인 되었음.
	out.print(id+"님 환영합니다!");
	out.print("[<a href='member/logout.jsp'> 로그아웃</a> ] ");
}


%>


<% 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
String today = sdf.format(new Date());

%> 
<div>[<%= today %>]</div>

</body>
</html>