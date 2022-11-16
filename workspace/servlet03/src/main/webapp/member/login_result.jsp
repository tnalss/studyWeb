<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>로그인 정보</h3>


<!-- 자바빈사용 -->
<jsp:useBean id="member" class="dto.MemberDTO" scope="session" />

<jsp:setProperty property="*" name="member"/> 
<!-- 한꺼번에 담을 수도 있다! -->

<!-- <jsp:setProperty property="id" name="member"/>  -->
<!-- <jsp:setProperty property="pw" name="member"/>  -->
<!-- 담았다 -->


id : <div><jsp:getProperty property="id" name="member"/></div>
pw : <div><jsp:getProperty property="pw" name="member"/></div>
<!-- 출력 -->
<!-- 스프링에서는 이런거 비슷하게 진행 됨 일단은 기초만잡아놓자 -->


<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
/* 아이디, 비번 모두 입력되어있으면 로그인된 것으로 간주 */

if(id.isEmpty() || pw.isEmpty() ){
	//다시 로그인화면으로 넘겨줘야함.
	//response.sendRedirect("login.jsp");
} else {
	//로그인된 정보는 모든 페이지에서 접근할 수 있도록 세션에 담는다.
	session.setAttribute("id", id); // 지정한 속성명으로 값을 세션에 담는다.
	session.setAttribute("pw",pw);
	
	//넘겨보장
	//response.sendRedirect("../");
}

%>




</body>
</html>