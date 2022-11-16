<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href = 'sum.jsp'>합 계산하기</a></div>
<div><a href = 'out.jsp'>출력하기</a></div>
<div><a href = 'calculate.jsp'>계산기</a></div>

<%@	include file="include/today.jsp" %>

<hr>

<h3>홈[ <%=pageContext.getAttribute("pageInfo") %>

<%= request.getAttribute("requestInfo") %> ]</h3>

<% 
Date date = new Date();

SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 E a hh시 mm분 ss초");
String now = df.format(date);
%>
<%
String result = (String) request.getAttribute("result");
if(result != null)
	out.print(result);

%>


<div>날짜정보 : <%= date %></div>
<div>현재 : <%=now %></div>
<hr>


<div> jsp에서서 선언할 수 있는 것들 </div>
<ul>
<li>html태그선언</li>
<li>jsp스크립팅 : java코드</li>
<li>jsp 표준 액션</li>
<li>EL</li>
<li>JSTL</li>
</ul>

<%-- <%@	include file="include/footer.jsp" %> --%>
<jsp:include page="include/footer.jsp">

<jsp:param name='email' value='test@naver.com'/>
<jsp:param name='phone' value='010-555-5555'/>
</jsp:include>
</body>
</html>