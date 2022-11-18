<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>포맷 라이브러리</h3>
	<h4>날짜포맷</h4>
	<c:set var='today' value='<%=new Date()%>' />

	<ul>
		<li>오늘 : ${ today }</li>
		<li>
			<!-- 	기본형태 --> <fmt:formatDate value="${today }" />
		</li>
		<li>
			<!-- medium 기본형태 --> <fmt:formatDate value="${today }" dateStyle='medium' />
		</li>
		<li>
			<!-- short	형태 --> <fmt:formatDate value="${today }" dateStyle='short' />
		</li>
		<li>
			<!-- long 형태 --> <fmt:formatDate value="${today }" dateStyle='long' />
		</li>
		<li>
			<!-- 패턴 형태 -->많이쓰는 패턴지정: <fmt:formatDate value="${today }" pattern='yy-MM-dd ahh:mm:ss' />
		</li>
		<li>
			<!-- 패턴 형태 -->많이쓰는 패턴지정: <fmt:formatDate value="${today }" pattern='yy-MM-dd ahh:MM:ss' />
		</li>
		
		<li>현재 : 
		<fmt:formatDate value='${today }' type='time' timeStyle='full'/>
		
		</li>
		
	</ul>



</body>
</html>