<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 동일하게 출력해보기 forward되었을때 결과생각해보기 -->
<div class="">page값 : <%= pageContext.getAttribute("pageData") %></div>
<div class="">EL로 출력 : ${pageData}</div>
<!-- page값은 녹아버렸 -->
<br>
<div class="">request값 : <%= request.getAttribute("requestData") %></div>
<div class="">EL로 출력 : ${requestData}</div>
<br>
<div class="">session값 : <%= session.getAttribute("sessionData") %></div>
<div class="">EL로 출력 : ${sessionData}</div>

<br>
<div class="">여러 값을 동일 이름으로 데이터를 넣었을 때 : ${ data }</div>

<br>

<div class="">값 지정해서 찾을때 request : ${ requestScope.data }</div>


</body>
</html>