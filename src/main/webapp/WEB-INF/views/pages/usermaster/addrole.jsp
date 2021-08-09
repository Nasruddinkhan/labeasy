<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Add User Role</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add user Role">
					<em class="fa fa-plus" data-toggle="modal"
						data-target="#add-role-modal"> Add user Role</em>
				</button>

			</div>
		</div>
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="12%">Role Id</th>
						<th width="">Role Code</th>
						<th width="">Role Name</th>
						<th>Description</th>
						<th width="">Role Type</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userRoleList}" var="userRole">
						<tr>
							<td>${userRole.roleId}</td>
							<td>${userRole.roleCode}</td>
							<td>${userRole.roleName}</td>
							<td>${userRole.description}</td>
							<td>${userRole.roleType}</td>
							<td><div class="box-tools pull-center">
									<a href="#"><button type="button"
											class="btn btn-sm btn-info btn-box-tool"
											onclick="roleEdit('${userRole.roleId}','${userRole.roleCode}','${userRole.roleName}','${userRole.roleType}','${userRole.description}')">
											<i class="fa fa-edit" style="color: white"></i>
										</button></a>
										<a href="${pageContext.request.contextPath}/role-master/show-role-permissions">
										<button type="button"
											class="btn btn-sm btn-danger btn-box-tool">
										<i class="fa fa-clock-o" style="color: white"></i>
										</button></a>
										<button type="button" class="btn btn-xs btn-toggle active"
											data-toggle="button" aria-pressed="true">
											<div class="handle"></div>
										</button>

								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Model start  -->
		<div class="modal fade" id="add-role-modal">
			<div class="modal-dialog">
				<form method="POST" id="add-role-form" autocomplete="off">
					<input type="hidden" id="role_id" name="role_id">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Role</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Role Code :</label> <input type="text" id="rolecode"
										name="rolecode" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Role Name :</label> <input type="text" id="rolename"
										name="rolename" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Role Type :</label> <select name="roletype"
										id="roletype" class="form-control ">
										<option value="">--select--</option>
										<option value="Lab Admin">Lab Admin</option>
										<option value="Lab Supervisor">Lab Supervisor</option>
										<option value="Lab User">Lab User</option>
									</select>
								</div>
								<div class="form-group col-sm-6">
									<label>Description :</label> <input type="text"
										id="description" name="description" class="form-control" />
								</div>
							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addUserRole()"
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