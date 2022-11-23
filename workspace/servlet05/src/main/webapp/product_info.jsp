<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<a href="productList.ju">이전으로</a>
</div>

<h3>상품 상세정보</h3>

<table border='1'>
<tr>
<th>상품 번호</th>
<td>${ dto.num }</td>
</tr>
<tr>
<th>상품명</th>
<td>${ dto.name }</td>
</tr>
<tr>
<th>출판사</th>
<td>${ dto.company }</td>
</tr>
<tr>
<th>가격</th>
<td>${ dto.price }</td>
</tr>
<tr>
<th>수량</th>
<td>${ dto.qty }</td>
</tr>




</table>

</body>
</html>