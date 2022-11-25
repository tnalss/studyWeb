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
<div class="container mx-auto">
					<h2 class="mt-4 text-center">신규 고객 등록</h2>
					<form action="insert.cu" method="post">
						<table class="table table-bordered text-center mx-auto mt-3">
							<thead>
								<tr>
									<th scope="col">고객명</th>
									<td><input type="text" name="name" /></td>
								</tr>
								<tr>
									<th scope="col">성별</th>
									<td>
									
									<input type="radio" id='male' name="gender" value="남" checked />
									<label for="male">남</label>
									
									<input type="radio" id='female' name="gender" value="여" />
									<label for="female">여</label></td>
								</tr>
								<tr>
									<th scope="col">이메일</th>
									<td><input type="text" name="email" /></td>
								</tr>
								<tr>
					
									<th scope="col">전화번호</th>
									<td><input type="text" name="phone" /></td>
								</tr>
							</thead>
						</table>
						<div class="mt-5 text-center">
					
							<button type="button" onclick="$('form').submit()"
								class="btn btn-primary">저장</button>
							<button type="button" onclick='history.go(-1)'
								class="btn btn-secondary">취소</button>
						</div>
					
					
					</form>
				</div>



			</div>
		</div>
	</div>

</body>
</html>