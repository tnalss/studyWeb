<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>
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
	int num1 = Integer.parseInt(request.getParameter("num1"));
	String operator = (String) request.getParameter("operator");
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	
	//
	
	%>




</body>
</html>