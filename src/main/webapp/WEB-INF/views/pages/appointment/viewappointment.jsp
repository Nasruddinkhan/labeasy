<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-primary ">
		<div class="box-header with-border">
			<h3 class="box-title">View Appointment
				-${appointment.appointmentId} Name: -${appointment.name}</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<em class="fa fa-minus"></em>
				</button>

			</div>
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
							<td>${andInvoices.billingId}</td>
							<td>${andInvoices.paymentDate}</td>
							<td>${andInvoices.totalAmmount}</td>
							<td>${andInvoices.discountAmmount}</td>
							<td>${andInvoices.discountReason}</td>
							<td>${andInvoices.advancePayment}</td>
							<td>${andInvoices.paymentAmmount}</td>
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
						<th>Test-ID</th>
						<th>Test-Name</th>
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
			<button type="button" class="btn btn-sm  btn-danger printinvoice">Print Invoice</button>
		</div>
	</div>
</section>

