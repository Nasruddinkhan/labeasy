
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">View Users</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="View docters">
					<a
						href="${pageContext.request.contextPath}/doctor-master/add-doctor"><i
						class="fa fa-plus"></i> Add New Doctor</a>
				</button>
			</div>
		</div>

		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Speciality</th>
						<th>Registration Id</th>
						<th>Contact</th>
						<th>Email</th>
						<th>Address</th>
						<th>Incentice Percentage</th>
						<th>Managed By</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${doctorList}" var="doctor">
						<tr>
							<td>${doctor.id}</td>
							<td>${doctor.prefix} ${doctor.name}</td>
							<td>${doctor.speciality}</td>
							<td>${doctor.registrationId}</td>
							<td>${doctor.mobileNo}</td>
							<td>${doctor.emailId}</td>
							<td>${doctor.address}</td>
							<td>${doctor.incenticePercentage}</td>
							<td>${doctor.managedBy}</td>
							<td><div class="box-tools pull-center">
									<a
										href="${pageContext.request.contextPath}/doctor-master/edit-doctor/${doctor.id}"><button
											type="button" class="btn btn-sm btn-info btn-box-tool">
											<i class="fa fa-edit" style="color: white"></i>
										</button> </a> <a href="#"><button type="button"
											class="btn btn-sm btn-danger btn-box-tool">

											<i class="fa fa-trash" style="color: white"></i>
										</button> </a>

								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</section>
