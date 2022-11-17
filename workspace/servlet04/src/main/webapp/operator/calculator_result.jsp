<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class=""><a href="calculator.jsp">이전으로</a></div>
<hr />

<h3>EL 논리연산자</h3>
<div>no1 : 값이 ${ empty param.no1 ? '없다' : '있다' }</div>
<div>no3 : 값이 ${ empty param.no3 ? '없다' : '있다' }</div>
<div>no1 값과 no2 값이 ${ !empty param.no1 and ! empty param.no2 ?'둘 다 있다' :'둘다있지않다.' }</div>
<div>no1 값과 no2 값이 ${ empty param.no1 || empty param.no2 ? '둘 중 적어도 한개는 값이 없다.': '둘 다 값이 있다.' }</div>




<hr />
<h3>EL 비교연산자</h3>
<div class="">${ param.no1 } 와 ${ param.no2 } 중 더 큰 수는 ${ (param.no1-param.no2>0) ? param.no1:param.no2}</div>

<hr />

<h3>EL 산술연산자</h3>
<div>${ param.no1 } + ${ param.no2 } = ${param.no1 + param.no2}</div>
<div>${ param.no1 } - ${ param.no2 } = ${param.no1 - param.no2}</div>
<div>${ param.no1 } * ${ param.no2 } = ${param.no1 * param.no2}</div>
<div>${ param.no1 } / ${ param.no2 } 
			= ${param.no2 == 0 ? 0 : param.no1 / param.no2}</div>
<div>${ param.no1 } / ${ param.no2 } 
			= ${param.no2 == 0 ? 0 : param.no1 div param.no2}</div>
<div>${ param.no1 } % ${ param.no2 } 
			= ${param.no2 == 0 ? 0 : param.no1 % param.no2}</div>
<div>${ param.no1 } % ${ param.no2 } 
			= ${param.no2 == 0 ? 0 : param.no1 mod param.no2}</div>



</body>
</html>