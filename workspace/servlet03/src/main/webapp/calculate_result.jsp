<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>
<div><a href="./">홈으로</a></div>
<div><a href="calculate.jsp">이전화면</a></div>
<%@ include file='include/today.jsp' %>
<hr />
<%!
int result=0;
void Calculator(int num1, int num2 , String operator) {
	switch (operator) {

	case "+":
		result = num1 + num2;
		break;

	case "-":

		result = num1 - num2;
		break;
	case "*":

		result = num1 * num2;
		break;
	case "/":

		result = num1 / num2;
		break;

	}
}
%>

<%
try{
	int num1 = Integer.parseInt(request.getParameter("num1"));
	String operator = (String) request.getParameter("operator");
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	Calculator(num1,num2,operator);
	String str="계산 결과 : " +num1 +" "+ operator +" " +  num2 + " = " + result;
	out.print(str);
		
	
	request.setAttribute("result", str);
	request.getRequestDispatcher("index.jsp").forward(request, response);
}catch(Exception e){
	request.setAttribute("error", e);
	request.getRequestDispatcher("calculate_error.jsp").forward(request, response);
}
	
		
%>


</body>
</html>