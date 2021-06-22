<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- Basic -->
<meta charset="UTF-8">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Web Fonts  -->
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/iCheck/square/blue.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<link href="${pageContext.request.contextPath}/resources/css/toastr.css"
	rel="stylesheet" />
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>Easy</b>Lab</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>

			<form action='<spring:url value="/login"/>' onsubmit="return validateLoginForm()" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="username" id="username"
						placeholder="username"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control" id="password"
						placeholder="Password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox" name="remember-me">
								Remember Me
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">
							Sign In</button>
					</div>
					<!-- /.col -->
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>


			<!-- /.social-auth-links -->
			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
				<div class="error">
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</div>
			</c:if>


		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src=".${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/toastr.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
	

	<script
		src="${pageContext.request.contextPath}/resources/js/appvalidation.js"></script>

	<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
  function validateLoginForm(){
	const isValidName =  isFieldValidation('#username', 'username cannot be empty');
	const isValidPassword =   isFieldValidation('#password', 'password cannot be empty');
	  return (isValidName && isValidPassword);
  }
</script>
</body>
</body>
</html>