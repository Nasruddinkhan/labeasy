<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.fancybox.css"
	rel="stylesheet" type="text/css" />
<style>
.fancybox-content {
	width: 360px !important;
	height: 400px !important;
}
</style>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">View Appointments</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add Appointment">
					<a
						href="${pageContext.request.contextPath}/appointment/show-appointment-page"><i
						class="fa fa-plus"></i> Add Appointment</a>
				</button>
			</div>
		</div>
		<c:if test="${not empty appointment}">
			<div class="box-body">
				<table id="example1"
					class="table table-sm table-bordered table-striped">
					<thead>
						<tr>
							<th>Ap Id</th>
							<th>Name</th>
							<th>Mobile No</th>
							<th>Visit date time</th>
							<th>Status</th>
							<th>Assigned to</th>
							<th>Due Amount</th>
							<th>Balance</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${appointment}" var="app">
							<tr>
								<td><em > <a class="viewappointment" href="${pageContext.request.contextPath}/appointment/appointment-view-popup?appId=${app.appointmentId}">AP
											${app.appointmentId}</a></em></td>
								<td>${app.name}</td>
								<td>${app.mobileNo}</td>
								<td>${app.appointmentDate}-${app.appointmentTime}</td>
								<td><em class="fa fa-circle "></em> New</td>
								<td>${app.assignTo}</td>
								<td><c:choose> 
										<c:when test="${app.andInvoiceDto.paymentAmmount > 0}">
											<em> <a class="billingiframe"
												href="${pageContext.request.contextPath}/appointment/cleardue-popup?appId=${app.appointmentId}
										&advPay=${app.andInvoiceDto.advancePayment}
										&dueAmt=${app.andInvoiceDto.paymentAmmount}
										&paymentDate=${app.andInvoiceDto.paymentDate}
										&discountAmmount=${app.andInvoiceDto.discountAmmount}
										&discountReason=${app.andInvoiceDto.discountReason}">
													${app.andInvoiceDto.paymentAmmount} </a>
											</em>
										</c:when>
										<c:otherwise>
											<em> ${app.andInvoiceDto.paymentAmmount} </em>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${app.andInvoiceDto.paymentAmmount > 0}">
										${app.andInvoiceDto.advancePayment}
										</c:when>
										<c:otherwise>
										${app.andInvoiceDto.totalAmmount}
										</c:otherwise>
									</c:choose></td>
								<td><div class="box-tools pull-center">
										<a
											href="${pageContext.request.contextPath}/appointment/editAppointment/${app.appointmentId}">
											<button type="button"
												class="btn btn-sm btn-info btn-box-tool">
												<i class="fa fa-edit" style="color: white"></i>
											</button>
										</a> <a href="#"><button type="button"
												class="btn btn-sm btn-danger btn-box-tool">

												<i class="fa fa-trash" style="color: white"></i>
											</button> </a> <a href="#">
											<button type="button"
												class="btn btn-sm btn-warning btn-box-tool">
												<i class="fa fa-upload" style="color: white"></i>
											</button>
										</a> <a href="#">
											<button type="button"
												class="btn btn-sm btn-success btn-box-tool">
												<i class="fa fa-whatsapp" style="color: white"></i>
											</button>
										</a> <a href="#">
											<button type="button"
												class="btn btn-sm btn-primary btn-box-tool">
												<i class="fa fa-envelope" style="color: white"></i>
											</button>
										</a>

									</div></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</c:if>
	
	</div>
</section>
