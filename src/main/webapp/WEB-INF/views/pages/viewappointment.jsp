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
				<h3 class="box-title">View Appointment
					-${appointment.appointmentId}  Name: -${appointment.name}</h3>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3 txtCenter">
						<strong>Name :</strong>
					</div>
					<div class="col-sm-3">AP${appointment.name}</div>
					<div class="col-sm-3 txtCenter">
						<strong>Gender :</strong>
					</div>
					<div class="col-sm-3">
						<c:choose>
							<c:when test="${appointment.gender == 'M'}">
												Male
											</c:when>
							<c:when test="${appointment.gender == 'F'}">
												Female
											</c:when>
							<c:otherwise>
											 Transgender
											</c:otherwise>
						</c:choose>
					</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Mobile :</strong>
					</div>
					<div class="col-sm-3">${appointment.mobileNo}</div>
					<div class="col-sm-3">
						<strong>Referred By :</strong>
					</div>
					<div class="col-sm-3">${appointment.reffredBy}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Email :</strong>
					</div>
					<div class="col-sm-3">${appointment.emailId}</div>
					<div class="col-sm-3">
						<strong>Appointment Date :</strong>
					</div>
					<div class="col-sm-3">${appointment.appointmentDate}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Preffrred Lab :</strong>
					</div>
					<div class="col-sm-3">${appointment.appointmentId}</div>
					<div class="col-sm-3">
						<strong>Age :</strong>
					</div>
					<div class="col-sm-3">${appointment.age}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Assignee :</strong>
					</div>
					<div class="col-sm-3">${appointment.assignTo}</div>
					<div class="col-sm-3">
						<strong>Remark :</strong>
					</div>
					<div class="col-sm-3">${appointment.remarks}</div>
				</div>

			</div>
			<div class="box-body">
				<div class="row">
					<div class="col-sm-3">
						<strong>Address :</strong>
					</div>
					<div class="col-sm-3">${appointment.address}</div>
				</div>

			</div>

		</div>
		<div class="box box-primary ">
			<div class="box-header with-border">
				<h3 class="box-title">Billing Details</h3>
			</div>
			<div class="">
				<table class="table table-sm table-bordered table-striped">
					<thead>
						<tr>
							<th>InvoiceNo</th>
							<th>B.Date</th>
							<th>T.Amt</th>
							<th>Dis. Amt</th>
							<th>Dis.Res</th>
							<th>Paid.Amt</th>
							<th>Due Amount</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${appointment.andInvoices}" var="andInvoices">
							<tr>
								<td> ${andInvoices.billingId}</td>
								<td> ${andInvoices.paymentDate}</td>
									<td> ${andInvoices.totalAmmount}</td>
									<td> ${andInvoices.discountAmmount}</td>
									<td> ${andInvoices.discountReason}</td>
									<td> ${andInvoices.advancePayment}</td>
									<td> ${andInvoices.paymentAmmount}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
		<div class="box box-primary ">
			<div class="box-header with-border">
				<h3 class="box-title">Billing Details</h3>
			</div>
			<div class="">
				<table class="table table-sm table-bordered table-striped">
					<thead>
						<tr>
							<th>Test-ID</th>
							<th>Test-Name</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
	</section>
	<jsp:include page="headerscript.jsp" />
</body>
</html>