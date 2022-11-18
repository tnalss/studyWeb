<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class=""><a href="../">홈으로</a></div>
<hr />

<h3>파라미터 확인</h3>
<div class="">이름 : ${ param.name }</div>
<div class="">전화번호 : ${ phone[ param.name ] }</div>
<div class="">성별 : ${ param.gender }</div>
<div class="">
 
기존에 우리가 사용한 방식=> 선택한값이 없어서 오류가 뜨기도.

<%
//String[] sports = request.getParameterValues("sports");
//for(String s : sports){
//	out.print(s + "&nbsp");
//}

%>
</div>

<div class="">EL을 사용한 방식 </div>

<div class="">취미 :
<%-- ${paramValues.sports[0] } --%>
<%-- ${paramValues.sports[1] } --%>
<%-- ${paramValues.sports[2] } --%>
<%-- ${paramValues.sports[3] } --%>

<!-- 코어라이브러리 이용 -->
<c:forEach items='${paramValues.sports}' var='s' varStatus='state'>
	${state.first ? '' :',' } ${s}
</c:forEach>



</div>

<hr />
<h3>내부적으로 가지고 있는 설정값</h3>
<div>요청url : ${pageContext.request.requestURL } </div>
<div>호스트명(서버이름) : ${pageContext.request.serverName } </div>
<div>어플리케이션 : ${pageContext.servletContext.contextPath } </div>
<div>요청uri : ${pageContext.request.requestURI } </div>



</body>
</html>