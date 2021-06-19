
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
					title="View Appointments">
					<a
						href="${pageContext.request.contextPath}/user-master/add-new-user"><i
						class="fa fa-plus"></i> Add New User</a>
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
						<th>Mobile</th>
						<th>Email</th>
						<th>Joining Date</th>
						<th>Role</th>
						<th>Reporting to</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usersList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.firstName}${user.lastName}</td>
							<td>${user.mobileNo}</td>
							<td>${user.emailId}</td>
							<td>${user.doj}</td>
							<td>${user.userRoleDto.roleName}</td>
							<td><c:if test="${not empty user.reportingUser}">
										${user.reportingUser.firstName} ${user.reportingUser.lastName}
										</c:if></td>

							<td><div class="box-tools pull-center">
									<a
										href="${pageContext.request.contextPath}/user-master/edit-user/${user.id}"><button
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
		<!-- Model start  -->
		<div class="modal fade" id="test-group">
			<div class="modal-dialog">
				<form method="POST" id="add-group-form" autocomplete="off">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Test Group</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Name :</label> <input type="text" id="name" name="name"
										class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Description :</label> <input type="text"
										id="description" name="description" class="form-control" />
								</div>
							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addGroup()"
								class="btn btn-primary">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
</section>
