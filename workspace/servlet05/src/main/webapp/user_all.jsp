<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>전체 사용자정보 목록</h3>
<table border='1'>
<tr><th>아이디</th><th>이름</th><th>이메일</th><th>관리자여부</th><th>잔고</th></tr>

<c:forEach var= 'dto' items='${user_list }'>
<tr>
<td><a href='info.ju?id=${dto.id}'>${dto.id}</a>  </td>
<td>${dto.name}</td>
<td>${dto.email}</td>
<td>${dto.admin}</td>
<td>${dto.money}</td>
</tr>
</c:forEach>

</table>

<hr />
	<h3>전체 사용자 이름 목록</h3>
	<c:forEach var='name' items='${list }'>
		<div>${ name }</div>
	</c:forEach>
</body>
</html>