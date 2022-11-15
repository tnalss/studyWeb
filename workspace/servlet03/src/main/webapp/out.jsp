<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href='./'>홈으로</a>
	</div>
	<%@ include file='include/today.jsp' %>
	
	<hr>
	<h2>출력하기</h2>
	<div>1~10까지 출력</div>
	<%
	for (int i = 1; i <= 10; i++) {
	%>
	<div><%=i%></div>
	<%
	}
	%>
	<hr>
	<%
	for (int i = 1; i <= 10; i++) {
		out.print("<div>"+i+"</div>");
	}
	%>



</body>
</html>