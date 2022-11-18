<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="<c:url value='/'/>">홈으로</a>
	</div>
	<div>
		<a href="<c:url value='/jstl/'/>">이전으로</a>
	</div>
	<hr />
	<h3>함수라이브러리</h3>
	<c:set var='title' value='   함수 라이브러리 FUNCTIONS' />
	<!-- 	스페이스바를 여러번 눌러도 html이기때문에 스페이스바를 한번만 누른 것처럼 출력이 된다. nbsp로 해결하는 방법  -->
	<h4>[${title}]</h4>
	<ul>
		<li>문자열의 길이 : ${fn:length(title)}</li>
		<!--공백의 숫자도 포함된다 -->
		<li>문자열의 일부 : [${fn:substring(title,6,11)}]</li>
		<!--끝위치값은 생략할수없다. -->
		<li>문자열의 공백제거 : [${fn:trim(title)}]</li>
	</ul>
	<c:set var='email' value='indoubt@naver.com' />
	<h4>[${email }]</h4>
	<ul>
		<li>특정문자열의 위치 : [${fn:indexOf(email,'@')}]</li>
		<li>아이디만 출력 : ${fn:substring(email,0, fn:indexOf(email,'@'))}</li>

		<li>서비스 출력 :
			${fn:substring(email,fn:indexOf(email,'@')+1,fn:length(email))}</li>


		<li>회사이름 출력 :
			${fn:substring(email,fn:indexOf(email,'@')+1,fn:indexOf(email,'.'))}</li>
		<li>문자열 변경 : ${fn:replace(email, '.com', '.co.kr')}</li>
		<li>문자열 변경 : ${fn:replace(email, 'o' , 'e') }</li>
		<li>대문자화 : ${fn:toUpperCase(email)}</li>
		<li>소문자화 : ${fn:toLowerCase(title)}</li>
		<li>특정문자열이 포함되어 있는지 확인 : ${fn:contains(email,'.com')}</li>
		<li>존재 유무 : <c:if test="${fn:contains(email,'.com')}">
	com있음</c:if> <c:if test="${!fn:contains(email,'.co.kr')}">
	co.kr없음</c:if></li>
	</ul>

	<!-- 서비스 출력 토큰으로? :  -->
	<%-- <c:forTokens items='${ email}' delims="@" varStatus="status" > --%>
	<%-- 	${status.first ? e: '' }  --%>
	<%-- </c:forTokens> --%>
	<hr />

	<%
	String fruits[] = { "귤", "배", "감" };
	%>
	<!-- 이렇게 쓸 수도 있따 -->
	<c:set var='fruits' value='<%=fruits%>' />
	<h4>문자연결 및 분리</h4>
	<ul>
		<li>문자연결 : ${fn: join(fruits , '+') }</li>
		<li>문자연결 : ${fn: join(fruits , '<br>') }</li>

	</ul>
	<%
	String data = "java,oracle/html?css,jquery";
	request.setAttribute("subject", data);
	%>

	<ul>
	<!-- 	split시키면 배열이다 => 반복문 필요-->
		<li>문자 분리 : 
		<c:forEach	items="${fn: split( subject , ',' )}" var="s">
				<div> ${s} </div>
			</c:forEach>
		</li>
	</ul>


</body>
</html>