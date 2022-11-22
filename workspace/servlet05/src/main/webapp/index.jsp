<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>홈</h3>
	<div>
		<a href="<c:url value='/test.do'/>">조회테스트</a>
	</div>
	<div>
		<a href="<c:url value='/user.ju'/>">회원정보</a>
	</div>
	<div>
		<a href="<c:url value='/userAll.ju'/>">전체회원이름</a>
	</div>
		<div>
		<a href="<c:url value='/productList.ju'/>">전체 상품 목록</a>
	</div>
</body>
</html>