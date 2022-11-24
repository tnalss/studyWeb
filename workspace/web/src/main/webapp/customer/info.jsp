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
		<jsp:include page='../include/sidebar.jsp' />
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<jsp:include page='../include/navigation.jsp' />
			<!-- Page content-->
			<div class="container-fluid">
				<div class="container">
					<h3 class="mt-4 text-center">고객정보</h3>


					<table class="table table-bordered text-center">
						<thead>
							<tr>
								<th scope="col">고객명</th>
								<td>${dto.name }</td>
							</tr>
							<tr>
								<th scope="col">성별</th>
								<td>${dto.gender }</td>
							</tr>
							<tr>
								<th scope="col">이메일</th>
								<td>${dto.email}</td>
							</tr>
							<tr>
								<th scope="col">전화번호</th>
								<td>${dto.phone }</td>
							</tr>
						</thead>
					</table>
				</div>




			</div>
		</div>
	</div>

</body>
</html>