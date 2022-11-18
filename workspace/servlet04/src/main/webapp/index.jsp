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
<div class=""><a href="scope/scope_data.jsp">데이터 저장 및 출력</a></div>
<div class=""><a href="param/form_data.jsp">파라미터 출력</a></div>
<div class=""><a href="operator/calculator.jsp">계산기</a></div>
<div class=""><a href="array/array_data.jsp">배열,자료구조,맵</a></div>
<div class=""><a href="jstl/">JSTL</a></div>

<div><a href="<c:url value='../param/form_result.jsp?name=심청&gender=남' />">회원정보</a></div>
<!-- 밖에 "이면 안에는 ' , 밖이 '이면 안에는 " -->
<div><a href="<c:url value='/param/form_result.jsp?name=심청&gender=남' />">회원정보(절대주소)</a></div>
<div><a href="/el/param/form_result.jsp?name=심청&gender=남">회원정보(a태그절대주소)서버서비스path를 변경하면 안들어가짐</a></div>

<hr />
<h4>c:url에 변수를 담았쓰는방법</h4>
<c:url value='jstl/index.jsp' var='jstl'>
	<c:param name='name' value='박문수'/>

</c:url>

<a href="${jstl }">jstl링크</a>

</body>
</html>