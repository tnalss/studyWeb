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
				<h2 class="mt-4">사원 정보 수정</h2>
				<form action="update.hr" method="post">
					<table class="table table-bordered text-center mx-auto mt-3">
						<thead>
							<tr>
								<th scope="col">사번</th>
								<td>
								<input type="hidden" name="employee_id" value='${dto.employee_id }'/>
								${dto.employee_id }</td>
							</tr>
							<tr>
								<th scope="col">사원명</th>
								<td><input type="text" value="${dto.first_name}"
									name="first_name" placeholder="이름" /> <input type="text"
									value="${dto.last_name}" placeholder="성" name="last_name" /></td>
							</tr>
							<tr>

								<th scope="col">이메일</th>
								<td><input type="text" value="${dto.email}" name="email" /></td>
							</tr>
							<tr>

								<th scope="col">전화번호</th>
								<td><input type="text" value="${dto.phone_number}"
									name="phone_number" /></td>
							</tr>
							<tr>

								<th scope="col">급여</th>
								<td><input type="text" value="${dto.salary}" name="salary" /></td>
							</tr>

							<tr>

								<th scope="col">입사일자</th>
								<td><input type="date" value="${dto.hire_date}"
									name="hire_date" /></td>
							</tr>
							<tr>
								<th scope="col">부서</th>
								<td><select name="department_id">

										<option value='-1'>부서선택</option>
										<c:forEach var='d' items='${departments }'>
											<option value='${d.department_id}'
												${dto.department_name eq d.department_name ? 'selected': '' }>${d.department_name }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>

								<th scope="col">업무</th>
								<td>${job_title }<select name="job_id">
										<!-- job_id가 없는 사람은 없다. -->
										<c:forEach var='j' items='${jobs }'>
											<option value='${j.job_id }'
												<c:if test='${j.job_id eq dto.job_id }'>selected</c:if>>${j.job_title }</option>
										</c:forEach>
								</select>
								</td>
							</tr>

							<tr>

								<th scope="col">매니저</th>
								<td><select name="manager_id">
										<option value='-1'>매니저선택</option>
										<c:forEach var='m' items='${managers}'>
											<option value='${m.manager_id}'
												${m.manager_id eq dto.manager_id ? 'selected':'' }>${m.manager_name }</option>
										</c:forEach>
								</select></td>
							</tr>
						</thead>
					</table>
					<button type="button"
						onclick="$('form').submit()" 
						class="btn btn-primary">저장</button>
					<button type="button" onclick='location="info.hr?id=${dto.employee_id}"'
						class="btn btn-secondary">취소</button>



				</form>
			</div>
		</div>
	</div>

</body>
</html>