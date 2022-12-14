<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href = '<c:url value = "/" />'>홈으로 </a>
	</div>
	<div>
		<a href= '<c:url value = "/jstl/" />'>JSTL 메인</a>
	</div>
	<hr />

	<h3>코어 라이브러리 실습</h3>
	<h4>1. 변수</h4>
	<c:set var='name' value="홍길동" />
	<div>선언한 변수값 이름 : ${name }</div>
	<c:remove var='name' />
	<div>삭제후 변수값 이름 : ${name }</div>

	<hr />
	<h4>2. 조건문 - if문</h4>
	<c:set var='no1' value='15000' />
	<c:set var='no2' value='3000' />
	<div>
		${ no1 } 과 ${ no2 } 중 더 큰 수 :
		<c:if test="${no1-no2>0}">${no1}</c:if>
		<c:if test="${no2-no1>0 }">${no2}</c:if>
	</div>


	<hr />

	<h4>3. 조건문 - choose문</h4>
	<c:set var='score' value='78' />
	<c:choose>
		<c:when test='${score >=90}'>
			<c:set var='grade' value='A' />
		</c:when>
		<c:when test='${score ge 80}'>
			<c:set var='grade' value='B' />
		</c:when>
		<c:when test='${score >=70}'>
			<c:set var='grade' value='C' />
		</c:when>
		<c:when test='${score >=60}'>
			<c:set var='grade' value='D' />
		</c:when>
		<c:otherwise>
			<c:set var='grade' value='F' />
		</c:otherwise>
	</c:choose>

	<div>성적 ${score}: ${ grade} 학점</div>

	<hr />

	<h4>4. 반복문 - 기본for문</h4>
	<div>
		1~10까지 출력 :
		<c:forEach var='no' begin='1' end='10' step='1'>
	${ no }
	<c:set var='sum' value='${sum+no}' />
		</c:forEach>

	</div>
	<div>1~10까지의 합 : ${sum }</div>


	<hr />

	<h4>5. 반복문 - 향상된for문</h4>
	<h5>일반적인배열</h5>
	<%
	String subjects[] = { "java", "oracle", "html", "css", "jquery" };
	request.setAttribute("subjects", subjects);
	%>

	<div>
		과목명 :
		<c:forEach items='${subjects}' var='sub'>
${sub }
</c:forEach>

	</div>
	<h5>ArrayList</h5>
	<%
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(85);
	list.add(92);
	list.add(78);
	list.add(63);
	list.add(96);
	request.setAttribute("score_list", list);
	%>

	<div>
		성적 :
		<c:forEach items="${score_list}" var='e' varStatus='state'>
	${state.index eq 0 ? '' :',' } ${e}
<!-- 	varStatus를 이용해서 인덱스로 콤마찍기! -->
		</c:forEach>
	</div>

	<h5>HashMap</h5>
	<%
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	map.put("java", 85);
	map.put("oracle", 92);
	map.put("html", 78);
	map.put("css", 63);
	map.put("jquery", 96);
	request.setAttribute("map_list", map);
	%>
	<div>
		과목별 성적:
		<c:forEach items='${ map_list}' var='m' varStatus='state'>
	${state.first ? '' :',' }   ${ m.key } : ${ m.value }  ${state.last ? '끝' :'' } 
</c:forEach>
		<!-- 해쉬맵은 순서가 유지되지 않는다! -->
	</div>



	<hr>
	<h4>forEach 실습</h4>
	<%
	int no[] = { 10, 20, 30, 40, 50 };
	request.setAttribute("no", no);
	%>
	<div>JSTL forEach를 사용해 no에 있는 값을 출력</div>


	<div>
	<c:forEach var='d' begin='0' end='5'>
		${no[d ] }
	
	</c:forEach>
	</div>

	<div>
<!-- 	가장많이 쓰는 향상된 포문 -->
	
	<c:forEach items='${no }' var='s'>
		${s }
	</c:forEach>
	
	
	

	</div>
	
	<div>
		
	<c:forEach var='dan' begin='1' end='9' step='1' >
		 
		 3  *  ${  dan } = ${ 3  * dan } <br>
	
	</c:forEach>
	<hr>
	</div>

	<div>
		
	<c:forEach var='i' begin='2' end='9'  >
			${i } 단<br>
		 <c:forEach var='j' begin='1' end='9'  >
		 
			${i} * ${j} =  ${ i * j }<br>
	
		</c:forEach>
			<hr>
	</c:forEach>
	</div>




<hr />
<h4>6. 토큰 분리</h4>
<%
String data = "java,oracle/html?css,jquery";

request.setAttribute("subject",data);

%>
<!-- 왜안돼??????? -->

<c:forTokens items="${subject}" delims="," var="s">
	<div>${s }</div>
</c:forTokens>

<hr>
<h4>7. 페이지 이동, 링크 걸기</h4>
<div><a href="<c:url value='../param/form_result.jsp?name=심청&gender=남' />">회원정보</a></div>
<!-- 밖에 "이면 안에는 ' , 밖이 '이면 안에는 " -->
<div><a href="<c:url value='/param/form_result.jsp?name=심청&gender=남' />">회원정보(절대주소)</a></div>










</body>
</html>