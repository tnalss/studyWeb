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
				<h3 class="text-center">사원정보</h3>
				<table class="table table-bordered text-center mx-auto mt-3">
					<thead>
						<tr>
							<th scope="col">사번</th>
							<td>${dto.employee_id }</td>
						</tr>
						<tr>
							<th scope="col">사원명</th>
							<td>${dto.name}</td>
						</tr>
						<tr>

							<th scope="col">이메일</th>
							<td>${dto.email}</td>
						</tr>
						<tr>

							<th scope="col">전화번호</th>
							<td>${dto.phone_number}</td>
						</tr>
						<tr>
							<th scope="col">부서</th>
							<td>${dto.department_name}</td>
						</tr>
						<tr>

							<th scope="col">업무</th>
							<td>${dto.job_title}</td>
						</tr>
						<tr>

							<th scope="col">급여</th>
							<td>${dto.salary}</td>
						</tr>
						<tr>

							<th scope="col">입사일자</th>
							<td>${dto.hire_date}</td>
						</tr>
						<tr>

							<th scope="col">매니저</th>
							<td>${dto.manager_name}</td>
						</tr>
					</thead>
				</table>
				<div class="mt-5 text-center">
					<button type="button" onclick='location="list.hr"'
						class="btn btn-primary">사원목록</button>
					<button type="button"
						onclick='location="modify.hr?id=${dto.employee_id}"'
						class="btn btn-primary">사원정보 수정</button>
					<button type="button"
						class="btn btn-secondary delete">정보 삭제</button>
<!-- 					<button type="button" onclick="go_delete()"
						class="btn btn-secondary">정보 삭제</button> -->
				</div>

			</div>
		</div>
	</div>
	<script>
	$('.delete').click(function(){
		if(confirm('사번 [${dto.employee_id}] 정말로 삭제?')){
			location='delete.hr?id=${dto.employee_id}';
		}
		
	})
	</script>
</body>
</html>