<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 전체 목록</h3>

<table border = '1'>
<tr><th>상품번호</th><th>책 제목</th><th>회사명</th><th>가격</th><th>재고</th></tr>
<c:forEach var= 'dto' items='${list }'>
<tr>
<td><a href='productInfo.ju?no=${ dto.num }'> ${dto.num}</a>  </td>
<td>${dto.name}</td>
<td>${dto.company}</td>
<td>${dto.price}</td>
<td>${dto.qty}</td>
</tr>
</c:forEach>

</table>



</body>
</html>