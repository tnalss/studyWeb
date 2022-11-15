<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
<div class=""><a href="./">홈으로</a></div>
<%@ include file='include/today.jsp' %>
<form action="calculator_result.jsp" method="post">

<div class="">
<input type="text" name="num1"/>
<select name="operator" >
	<option value="+">+</option>
	<option value="-">-</option>
	<option value="*">*</option>
	<option value="/">/</option>

</select>

<input type="text" name="num2"/>
</div>

<input type="submit" value="계산하기"/>

</form>


</body>
</html>