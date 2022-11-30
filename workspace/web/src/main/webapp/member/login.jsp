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

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/common.css?<%=new java.util.Date()%>" rel="stylesheet" />
<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<!-- Jquery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>




</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<!-- Page content-->
			<div class="container-fluid text-center">

				<a href="<c:url value='/'/>"><img
					src="<c:url value='/images/hanul.logo.png'/>" alt="hanul logo"
					class="img-fluid" /></a>
				<div class="box align-middle">
					<ul>
						<li><input class="chk" type="text" id='userid' placeholder="아이디" /></li>
						<li><input class="chk" type="password" id='userpw' placeholder="비밀번호" /></li>
						<li><input onclick= "fn_login()" type="button" value="로그인" class="btn btn-primary" /></li>
					</ul>

				</div>


			</div>
		</div>
	</div>
<script>



function fn_login(){
	// 아이디 비밀번호 모두 input이 입력되어있는지 확인
	if (!emptyCheck()) return;
	
	$.ajax({
		url: 'smartLogin.mb',
		data : {id : $('#userid').val() , pw : $('#userpw').val()},
		success: function(response){
			console.log(response);
			console.log(typeof(response));
			console.log(false);
			if(JSON.parse(response))
				location='<c:url value="/"/>';
			else{
				alert("아이디나 비밀번호가 일치 하지 않습니다!");
			}
			
		},error:function(req,text){
			alert(text+':'+req.status);
		}
		
	});
}
$('#userpw').keyup(function(e){

	//엔터키 누를때만
	if(e.keyCode==13)
	fn_login();
})

function emptyCheck(){
	var ok = true
	$('.chk').each(function(){
		if( $(this).val()=='' ){
			var tag = $(this).attr('placeholder');
			console.log(tag);
			alert(tag + '를 입력하세요');
			$(this).focus();
			ok = false;
			return ok;
		}
	})
	return ok;
}


</script>

<!-- //위 세개 차이점확인하기!!	
			//ㄴㅓ무 불편하니까 라이브러리를 써먹자 메이븐 ㄱㄱ
			// jackson검색해서 라이브러리 추가 해주기!
이거 라이브러리 설치하면 response가 파란색으로 true false로 나와야 되는데안나옴


-->
</body>
</html>