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
				<h2 class="mt-4">사원목록</h2>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">사번</th>
							<th scope="col">사원명</th>
							<th scope="col">부서</th>
							<th scope="col">업무</th>
							<th scope="col">입사일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items='${list}'>
							<tr>
								<td scope="col">${dto.employee_id}</td>
								<td>${dto.first_name}</td>
								<td>${dto.department_id}</td>
								<td>${dto.job_id}</td>
								<td>${dto.hire_date}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>



			</div>
		</div>
	</div>

</body>
</html>