<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="">
<a href="../">홈으로</a>
</div>
<h3>취미 목록 - 배열출력</h3>
<div >${hobby[0] }</div>
<div >${hobby[1] }</div>
<div >${hobby[2] }</div>
<hr />

<h3>과일 목록 - ArrayList출력도 배열출력과 똑같다.</h3>
<div >${fruits[0] }</div>
<div >${fruits[1] }</div>
<div >${fruits[2] }</div>
<hr />

<h3>전화번호 - HashMap출력</h3>
<div> 홍길동 : ${phone['홍길동'] }</div>
<div> 심청 : ${phone['홍길동'] }</div>
<div> 박문수 : ${phone['홍길동'] }</div>

</body>
</html>