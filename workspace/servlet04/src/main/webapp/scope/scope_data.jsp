<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("pageData", 100);
request.setAttribute("requestData",200);
session.setAttribute("sessionData", 300);


%>
<div class="">page값 : <%= pageContext.getAttribute("pageData") %></div>
<div class="">EL로 출력 : ${pageData}</div>
<br>
<div class="">request값 : <%= request.getAttribute("requestData") %></div>
<div class="">EL로 출력 : ${requestData}</div>
<br>
<div class="">session값 : <%= session.getAttribute("sessionData") %></div>
<div class="">EL로 출력 : ${sessionData}</div>



<%

pageContext.setAttribute("data", 10);
request.setAttribute("data", 20);
session.setAttribute("data", 30);

%>
<br>
<div class="">여러 값을 동일 이름으로 데이터를 넣었을 때 : ${ data }</div>
<!-- 영역을 찾을때 page부터 찾는다 가까운거부터 보임-->
<!-- 똑같은 이름으로 데이터를 넣을 일은 없지만 속성을 안다~ -->
<!-- el은 어떤 형식으로 돌아가는지 알기 좋음 -->
<br>
<!-- 만약 딱집어서 조회하고 싶으면 어떻게 할까? -->
<div class="">값 지정해서 찾을때 page : ${ pageScope.data }</div>
<div class="">값 지정해서 찾을때 request : ${ requestScope.data }</div>
<div class="">값 지정해서 찾을때 session : ${ sessionScope.data }</div>
<!-- 다만 값을 지정해서 찾을일은 거의 없다 -->


<!-- forward시키면 어떻게 될까? -->
<%request.getRequestDispatcher("scope_result.jsp").forward(request,response); %>


</body>
</html>