<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
				<h2 class="mt-4 text-center">신규사원등록</h2>
				<form action="insert.hr" method="post">
<!-- modify태그 복사! -->
<table class="table table-bordered text-center mx-auto mt-3">
<thead>

							<tr>
								<th scope="col">사원명</th>
								<td><input type="text" 	name="first_name" placeholder="이름" /> <input type="text"
									 placeholder="성" name="last_name" /></td>
							</tr>
							<tr>

								<th scope="col">이메일</th>
								<td><input type="text"  name="email" /></td>
							</tr>
							<tr>

								<th scope="col">전화번호</th>
								<td><input type="text" 
									name="phone_number" /></td>
							</tr>
							<tr>

								<th scope="col">급여</th>
								<td><input type="text" name="salary" /></td>
							</tr>

							<tr>

								<th scope="col">입사일자</th>
								<td>
								
								<input type="date" value="<fmt:formatDate value='<%= new java.util.Date() %>' pattern='yyyy-MM-dd'/>"
									name="hire_date" /></td>
							</tr>
							<tr>
								<th scope="col">부서</th>
								<td><select name="department_id">

										<option value='-1'>부서선택</option>
										<c:forEach var='d' items='${departments }'>
											<option value='${d.department_id}'>${d.department_name }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>

								<th scope="col">업무</th>
								<td>${job_title }<select name="job_id">
										<!-- job_id가 없는 사람은 없다. -->
										<c:forEach var='j' items='${jobs }'>
											<option value='${j.job_id }'>${j.job_title }</option>
										</c:forEach>
								</select>
								</td>
							</tr>

							<tr>

								<th scope="col">매니저</th>
								<td><select name="manager_id">
										<option value='-1'>매니저선택</option>
										<c:forEach var='m' items='${managers}'>
											<option value='${m.manager_id}'>${m.manager_name }</option>
										</c:forEach>
								</select></td>
							</tr>
						</thead>
					</table>
					</form>
<div class="text-center">
						<button type="button"
							onclick="$('form').submit()" 
							class="btn btn-primary">저장</button>
						<button type="button" onclick='location="list.hr"'
							class="btn btn-secondary">취소</button>
					</div>


			</div>
		</div>
	</div>

</body>
</html>