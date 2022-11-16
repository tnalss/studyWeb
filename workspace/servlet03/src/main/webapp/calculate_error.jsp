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
Exception e = (Exception) request.getAttribute("error");
//에러가져오기		
String msg = "";
if (e instanceof ArithmeticException) {
	msg = "잘못된 연산 : 0으로 나눌 수 없습니다.";
} else if (e instanceof NumberFormatException) {
	msg = "숫자만 입력해야 합니다.";
} else if (e instanceof ArrayIndexOutOfBoundsException) {
	msg = "인덱스의 범위를 벗어났습니다.";
}

response.setContentType("text/html; charset=utf-8");
out.print("<html>");
out.print("<body>");
out.print("<h2>오류</h2>");
out.print("<div>");
out.print("내용: "+msg);
out.print("</div>");
out.print("<div>");
out.print(e.getMessage());
out.print("</div>");
out.print("빠른시일내에 복구하겠습니다.");
out.print("<div><a href='./'>홈으로</a></div>");

out.print("</body>");
out.print("</html>");

%>
</body>
</html>