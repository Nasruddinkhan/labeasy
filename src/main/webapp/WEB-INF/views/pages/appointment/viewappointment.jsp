<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-primary ">
		<div class="box-header with-border">
			<h3 class="box-title">View Appointment 
				Id - <b>AP${appointment.appointmentId}</b></h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<em class="fa fa-minus"></em>
				</button>

			</div>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Name :</strong>
				</div>
				<div class="col-sm-3">${appointment.name}</div>
				<div class="col-sm-3 ">
					<strong>Gender :</strong>
				</div>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${appointment.gender == 'M'}">Male</c:when>
						<c:when test="${appointment.gender == 'F'}">Female</c:when>
						<c:otherwise>Transgender</c:otherwise>
					</c:choose>
				</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Contact :</strong>
				</div>
				<div class="col-sm-3">${appointment.contactNo}</div>
				<div class="col-sm-3">
					<strong>Referred By :</strong>
				</div>
				<div class="col-sm-3">${appointment.referredBy}</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Email :</strong>
				</div>
				<div class="col-sm-3">${empty appointment.emailId ? 'None' : appointment.emailId}</div>
				<div class="col-sm-3">
					<strong>Appointment Date :</strong>
				</div>
				<div class="col-sm-3">${appointment.appointmentDate}</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Preferred Lab :</strong>
				</div>
				<div class="col-sm-3">${empty appointment.preferredLab ? 'None' : appointment.preferredLab}</div>
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
				<div class="col-sm-3">${appointment.assignToUserDto.firstName} ${appointment.assignToUserDto.lastName}</div>
				<div class="col-sm-3">
					<strong>Visit type :</strong>
				</div>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${appointment.visitType == 'N'}">
							Online Appointment
						</c:when>
						<c:otherwise>
							Customer visited
						</c:otherwise>
					</c:choose>
				</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Address :</strong>
				</div>
				<div class="col-sm-3">${appointment.addressLine1} ${appointment.addressLine2} ${appointment.cityId} ${appointment.pinCode}</div>
				
				<div class="col-sm-3">
					<strong>Remark :</strong>
				</div>
				<div class="col-sm-3">${empty appointment.remarks ? 'None' : appointment.remarks}</div>
			</div>

		</div>

	</div>
	<div class="box box-primary ">
		<div class="box-header with-border">
			<h3 class="box-title">Billing Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<em class="fa fa-minus"></em>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th>InvoiceNo</th>
						<th>Bill Date</th>
						<th>Discount Amt</th>
						<th>Discount Reason</th>
						<th>Paid Amt</th>
						<th>Due Amt</th>
						<th>Total Amt</th>
						<th>Invoice</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${appointment.addInvoices}" var="addInvoices">
						<tr>
							<td>${addInvoices.billingId}</td>
							<td>${addInvoices.paymentDate}</td>
							<td>${empty addInvoices.discountAmount ? 0.0 : addInvoices.discountAmount}</td>
							<td>${not empty addInvoices.discountReason ? addInvoices.discountReason : 'None'}</td>
							<td>${empty addInvoices.advancePayment ? 0.0 : addInvoices.advancePayment}</td>
							<td>${empty addInvoices.dueAmount ? 0.0 : addInvoices.dueAmount}</td>
							<td>${addInvoices.totalAmount}</td>
							<td onclick="openInvoiceInNewTab('${addInvoices.invoiceUrl}')">Invoice</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>
	<div class="box box-primary ">
		<div class="box-header with-border">
			<h3 class="box-title">Test Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<em class="fa fa-minus"></em>
				</button>

			</div>
		</div>
		<div class="box-body">
			<table class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th>Test ID</th>
						<th>Test Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${appointment.testNames}" var="test">
						<tr>
							<td>${test.testId}</td>
							<td>${test.name}</td>
							<td>${test.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<div class="row">
		<div class="col-sm-12 col-sm-offset-5">
			<a type="button" href="${pageContext.request.contextPath}/appointment/view-appointment-page" class="btn btn-sm btn-info">Back</a>
			<button type="button" class="btn btn-sm  btn-danger">Print Invoice</button>
		</div>
	</div>
</section>

