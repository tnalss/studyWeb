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
					<h3 class="text-center mt-5">고객목록</h3>
					<table class="table">
						<thead>
							<tr>
							<th scope="col"></th>
								<th scope="col">고객명</th>
								<th scope="col">이메일</th>
								<th scope="col">성별</th>
								<th scope="col">전화번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dto" items='${list}'>
								<tr>
								<td scope="col"></td>
									<td>
									<a href="info.cu?id=${dto.id}">
									${dto.name}</a></td>
									<td>${dto.email}</td>
									<td>${dto.gender}</td>
									<td>${dto.phone}</td>
								</tr>
							</c:forEach>
					
					
						</tbody>
					</table>
					
					
				<div class="text-center">
							<button type="button" onclick='location="new.cu"' class="btn btn-primary">신규 고객</button>
						</div>
				</div>





			</div>
		</div>
	</div>

</body>
</html>