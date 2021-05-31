<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
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
<style>
.fancybox-content {
	width: 360px !important;
	height: 400px !important;
}
</style>
</head>

<body>
	<section class="content">
		<div class="box box-primary ">
			<div class="box-header with-border">
				<h3 class="box-title">Due Clearance - AP${appId}</h3>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3 txtCenter">
						<strong>Appointment ID :</strong>
					</div>
					<div class="col-sm-3">AP${appId}</div>
					<div class="col-sm-3 txtCenter">
						<strong>Advance Paid :</strong>
					</div>
					<div class="col-sm-3">${advPay}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Due Amount :</strong>
					</div>
					<div class="col-sm-3">${dueAmt}</div>
					<div class="col-sm-3">
						<strong>Paid Date :</strong>
					</div>
					<div class="col-sm-3">${paymentDate}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Discount Amount :</strong>
					</div>
					<div class="col-sm-3">${discountAmmount}</div>
					<div class="col-sm-3">
						<strong>Discount Reason :</strong>
					</div>
					<div class="col-sm-3">${discountReason}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Payment Mode :</strong>
					</div>
					<div class="col-sm-3">
						<select name="paymentmode" id="paymentmode" class="form-control ">
							<option value="O">Online</option>
							<option value="F">Offline</option>
						</select>
					</div>
				</div>
			</div>
			<div class="box-body">
				<div class="row" align="center">
					<button type="submit" onclick="clearDue(${appId});"
						class="btn btn-primary btn-flat">Clear Due</button>
				</div>

			</div>
		</div>
	</section>
	<jsp:include page="headerscript.jsp" />
</body>
</html>