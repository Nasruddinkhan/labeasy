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
				<form method="POST" id="update-appointment-status">
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Change Status :</label> <select
								name="status" onchange="changeStatus(this)"
								class="form-control ">
								<option value="">--select--</option>
								<option value="AP">Assigned to Phlebotomist</option>
								<option value="SC">Sample Collected</option>
								<option value="SD">Sample Dropped</option>
								<option value="SP">Sample Under Process</option>
								<option value="SE">Sample Processed/Tested</option>
								<option value="RD">Report Dispatched</option>
							</select>
						</div>
						<div class="form-group col-sm-3" style="display: none"
							id="assign_to">
							<label for="Country Code">Assign to :</label> <select
								name="assignTo" id="assignUser" class="form-control ">
							</select>
						</div>
						<div class="form-group col-sm-3">
							<button style="margin-top: 2em;" type="button"
								onclick="updateAppointmentStatus();"
								class="btn btn-sm btn-success">Update Status</button>
						</div>
					</div>
				</form>
				<table id="example1"
					class="table table-sm table-bordered table-striped table-responsive">
					<thead>
						<tr>
							<th>Ap Id</th>
							<th>Name</th>
							<th>Mobile No</th>
							<th>Visit date time</th>
							<th>Status</th>
							<th>Assigned to</th>
							<th>Due Amt</th>
							<th>Paid Amt</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${appointment}" var="app">
							<tr>
								<td><input type="checkbox" id="appChk${app.appointmentId}"
									onclick="isCheckAppointment(${app.appointmentId})" /> <em>
										<a
										href="${pageContext.request.contextPath}/appointment/appointment-view-popup?appId=${app.appointmentId}">
											AP${app.appointmentId}</a>
								</em></td>
								<td>${app.name}</td>
								<td>${app.contactNo}</td>
								<td>${app.appointmentDate}-${app.appointmentTime}</td>
								<td><c:choose>
										<c:when test="${app.appStatus == 'AP'}">
											<em class="fa fa-user-md"></em> Assigned
										</c:when>
										<c:when test="${app.appStatus == 'CT'}">
											<em class="fa fa-motorcycle"></em> Visiting
										</c:when>
										<c:when test="${app.appStatus == 'SC'}">
											<em class="fa fa-medkit"></em> Collected
										</c:when>
										<c:when test="${app.appStatus == 'SD'}">
											<em class="fa fa-hospital-o"></em> Dropped
										</c:when>
										<c:when test="${app.appStatus == 'SP'}">
											<em class="fa fa-cog fa-spin"></em> Processing
										</c:when>
										<c:when test="${app.appStatus == 'SE'}">
											<em class="fa fa-check-circle"></em> Tested
										</c:when>
										<c:when test="${app.appStatus == 'RD'}">
											<em class="fa fa-truck"></em> Dispatched
										</c:when>
										
										<c:otherwise>
											<em class="fa fa-circle "></em> New
										</c:otherwise>
									</c:choose></td>
								<td>${app.assignToUserDto.firstName} ${app.assignToUserDto.lastName}</td>
								<td><c:choose>
										<c:when test="${app.addInvoiceDto.dueAmount > 0}">
											<em> <a class="billingiframe"
												href="${pageContext.request.contextPath}/appointment/cleardue-popup?appId=${app.appointmentId}
										&advPay=${empty app.addInvoiceDto.advancePayment ? 0 : app.addInvoiceDto.advancePayment}
										&dueAmt=${empty app.addInvoiceDto.dueAmount ? 0 : app.addInvoiceDto.dueAmount}
										&paymentDate=${app.addInvoiceDto.paymentDate}
										&discountAmount=${empty app.addInvoiceDto.discountAmount ? 0 : app.addInvoiceDto.discountAmount}
										&discountReason=${not empty app.addInvoiceDto.discountReason ? app.addInvoiceDto.discountReason : 'None'}">
										${app.addInvoiceDto.dueAmount} </a>
											</em>
										</c:when>
										<c:otherwise>
											<em> ${app.addInvoiceDto.dueAmount} </em>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${app.addInvoiceDto.dueAmount > 0}">
										${empty app.addInvoiceDto.advancePayment ? 0.0 : app.addInvoiceDto.advancePayment}
										</c:when>
										<c:otherwise>
										${app.addInvoiceDto.totalAmount}
										</c:otherwise>
									</c:choose></td>
								<td><div class="box-tools pull-center">
										<c:if test="${app.appStatus == 'NW' || app.appStatus == 'AP'  || app.appStatus == 'SC'}">
										<a
											href="${pageContext.request.contextPath}/appointment/editAppointment/${app.appointmentId}">
											<button type="button"
												class="btn btn-sm btn-info btn-box-tool">
												<i class="fa fa-edit" style="color: white"></i>
											</button>
										</a>
										</c:if>
										 <a href="#"><button type="button"
												class="btn btn-sm btn-danger btn-box-tool">

												<i class="fa fa-trash" style="color: white"></i>
											</button> </a> <a href="#">
											<button type="button"
												class="btn btn-sm btn-warning btn-box-tool">
												<i class="fa fa-upload" style="color: white"></i>
											</button>
										</a> 
										<c:if test="${app.isWhatsappActive == 'Y'}">
										<a href="#">
											<button type="button"
												class="btn btn-sm btn-success btn-box-tool">
												<i class="fa fa-whatsapp" style="color: white"></i>
											</button>
										</a>
										</c:if> 
										<c:if test="${app.emailId != ''}">
										<a href="#">
											<button type="button"
												class="btn btn-sm btn-primary btn-box-tool">
												<i class="fa fa-envelope" style="color: white"></i>
											</button>
										</a>
										</c:if>
									</div></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</c:if>

	</div>
</section>
