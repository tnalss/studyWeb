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
				<h2 class="mt-4 text-center">사원목록</h2>
				<form action="list.hr" method="post">
					<div id='list-top' class='container mt-5'>
						<ul>
							<li>부서명</li>
							<li><select onchange="$('form').submit()" name = "department_id">
							<option value="-1" >전체 부서</option>
							<c:forEach var='d' items='${departments}'>
							
									<option value="${d.department_id}" ${department_id eq d.department_id? 'selected' : ''}> ${d.department_name}</option>
									
							</c:forEach>
							<!-- null인경우 안나오니까 이상함 -->
							</select></li>
					
						</ul>
					
					
					</div>
				</form>

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
								<td><a href="info.hr?id=${dto.employee_id}">
										${dto.name}</a></td>
								<td>${dto.department_name}</td>
								<td>${dto.job_title}</td>
								<td>${dto.hire_date}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>

				<div class="text-center">
					<button type="button" onclick='location="new.hr"'
						class="btn btn-primary">신규 사원</button>
				</div>

			</div>
		</div>
	</div>

</body>
</html>