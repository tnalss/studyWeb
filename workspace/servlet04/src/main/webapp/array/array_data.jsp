<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="../">홈으로</a></div>
<hr />
<h3>배열, 자료구조(ArrayList, HashMap)</h3>
<%
String hobby[] = {"스포츠","바둑","유튜브"};
request.setAttribute("hobby", hobby);


ArrayList<String> list = new ArrayList<String>();
list.add("사과");
list.add("배");
list.add("바나나");
//request.setAttribute("fruits",list);
session.setAttribute("fruits",list);
//세션에 담으면 다른페이지에서도 보기가 가능!


HashMap<String,String> map = new HashMap<String,String>();
map.put("홍길동","010-1234-5768");
map.put("심청","062.8523.6547");
map.put("박문수","02-4568-8488");
session.setAttribute("phone",map);


request.getRequestDispatcher("array_result.jsp").forward(request, response);




%>


</body>
</html>