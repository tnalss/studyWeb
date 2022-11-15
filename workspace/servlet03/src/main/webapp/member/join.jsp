<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='../'>홈으로</a></div>
<%-- <%@ include file='../include/today.jsp' %> --%>
<%@ include file='/include/today.jsp' %>

<hr>

<h3>회원가입</h3>
<form method ='post' action='info.jsp'>
<div>이름 : <input type='text' name='name'></div>
<div>성별 : <input type='radio' name='gender' value='남' checked>남<input type='radio' name='gender' value='여' >여</div>
<div>취미 : 
<input type='checkbox' name='hobby' value='달리기'>달리기
<input type='checkbox' name='hobby' value='걷기'>걷기
<input type='checkbox' name='hobby' value='눕기'>눕기
<input type='checkbox' name='hobby' value='잠자기'>잠자기
</div>
<input type='submit' value='회원가입'>
</form>



</body>
</html>