<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class=""><a href="../">홈으로</a></div>
<hr />
<h3>계산기</h3>

<form action="calculator_result.jsp" method='get'>
<input type="text" name='no1'/>
<input type="text" name='no2'/>
<input type="submit" value='계산하기' />

</form>

<h3>세션에 담은 값을 어느곳에서나 출력가능</h3>
<div >${fruits[0] }</div>
<div >${fruits[1] }</div>
<div >${fruits[2] }</div>


</body>
</html>