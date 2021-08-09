<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>View Profile Details</b>
			</h3>
			<div class="box-tools pull-right">
			</div>
		</div>
		
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Name :</strong>
				</div>
				<div class="col-sm-3">${user.firstName} ${user.lastName}</div>
				<div class="col-sm-3 ">
					<strong>Gender :</strong>
				</div>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${user.gender == 'M'}">Male</c:when>
						<c:when test="${user.gender == 'F'}">Female</c:when>
						<c:otherwise>Transgender</c:otherwise>
					</c:choose>
				</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Father/Spouse Name :</strong>
				</div>
				<div class="col-sm-3">${user.fatherSpouseName}</div>
				<div class="col-sm-3">
					<strong>Date of Birth :</strong>
				</div>
				<div class="col-sm-3">${user.dob}</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Date of Joining :</strong>
				</div>
				<div class="col-sm-3">${user.doj}</div>
				<div class="col-sm-3">
					<strong>Contact :</strong>
				</div>
				<div class="col-sm-3">${user.mobileNo}</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Alternate Contact :</strong>
				</div>
				<div class="col-sm-3">${user.alternateMobileNo}</div>
				<div class="col-sm-3">
					<strong>Email :</strong>
				</div>
				<div class="col-sm-3">${user.emailId}</div>
			</div>

		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Aadhar Card No :</strong>
				</div>
				<div class="col-sm-3">${user.adharCardNo}</div>
				<div class="col-sm-3">
					<strong>PAN Card No :</strong>
				</div>
				<div class="col-sm-3">${user.panCardNo}</div>
			</div>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Other ID Card No :</strong>
				</div>
				<div class="col-sm-3">${user.otherIdCardNo}</div>
				<div class="col-sm-3">
					<strong>Role :</strong>
				</div>
				<div class="col-sm-3">${user.userRoleDto.roleName}</div>
			</div>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-3">
					<strong>Reporting person :</strong>
				</div>
				<div class="col-sm-3">${user.reportingUser.firstName} ${user.reportingUser.lastName}</div>
				<div class="col-sm-3">
					<strong>Address :</strong>
				</div>
				<div class="col-sm-3">${user.address.addressLine1} ${user.address.addressLine2} ${user.address.city} ${user.address.state} ${user.address.pinCode} ${user.address.country}</div>
			</div>
		</div>
	</div>		
	<div class="row">
		<div class="col-sm-12 col-sm-offset-5">
			<a type="button" href="${pageContext.request.contextPath}/dasboard" class="btn btn-sm btn-info">Back</a>
			<!-- <button type="button" class="btn btn-sm  btn-danger">Print Invoice</button> -->
		</div>
	</div>
</section>

