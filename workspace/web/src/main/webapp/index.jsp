<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Insert title here</title>
</head>
<body>

	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<jsp:include page='include/sidebar.jsp'/>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<jsp:include page='include/navigation.jsp'/>
			<!-- Page content-->
			<div class="container-fluid text-center">
				<h1 class="mt-4 text-center d-none">홈</h1>
				<img src="images/home.png" alt="홈이미지" class="img-fluid"/>


			</div>
		</div>
	</div>

</body>
</html>