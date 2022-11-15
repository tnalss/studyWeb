<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="../">홈으로</a></div>
<div><a href="join.jsp">회원가입</a></div>
<hr>


<% 
/*page scope = 선언된 현재페이지에서만 접근가능
request scope = 선언된 페이지와 forward되어지는 응답페이지에서도 접근가능*/
pageContext.setAttribute("pageInfo","스마트");
request.setAttribute("requestInfo", "웹&앱");
%>


<h3>회원정보[ <%=pageContext.getAttribute("pageInfo") %>

<%= request.getAttribute("requestInfo") %> ]</h3>
<%

String name = request.getParameter("name");
String gender = request.getParameter("gender");
String[] hobby = request.getParameterValues("hobby");


%>
<div class="">이름 : <%= name %></div>
<div class="">성별 : <%= gender %></div>
<div class="">취미 : <%
for(String h:hobby){
	out.print(h+"&nbsp");
}
%>

</div>

<%-- <% request.getRequestDispatcher("../index.jsp").forward(request,response); %> --%>
<% response.sendRedirect("../"); %>

</body>
</html>