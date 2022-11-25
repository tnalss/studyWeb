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
				<h2 class="mt-4 mx-auto">회원정보수정</h2>

				<form action="update.cu" method="post">
				<!-- 히든으로 아이디까지같이넘기자  -->
					<input type="hidden" name='id' value = '${dto.id }'/>
					<table class="table table-bordered text-center mx-auto mt-3">
						<thead>
							<tr>
								<th scope="col">고객명</th>
								<td><input type="text" name="name" value="${dto.name }"/></td>
							</tr>
							<tr>
								<th scope="col">성별</th>
								<td><input type="radio" name="gender" value="남" ${ dto.gender eq '남' ? 'checked' : '' } />남 <input
									type="radio" name="gender" value="여" ${ dto.gender == '여' ? 'checked' : '' } />여</td>
							</tr>
							<tr>
								<th scope="col">이메일</th>
								<td><input type="text" name="email" value="${dto.email }"/></td>
							</tr>
							<tr>

								<th scope="col">전화번호</th>
								<td><input type="text" name="phone" value="${dto.phone }" /></td>
							</tr>
						</thead>
					</table>

				</form>
						<div class="mt-5 text-center">
							
							<button type="button" onclick="$('form').submit()" class="btn btn-primary">완료</button>
							<button type="button" onclick='history.go(-1)' class="btn btn-secondary">취소</button>
						</div>

			</div>
		</div>
	</div>

</body>
</html>