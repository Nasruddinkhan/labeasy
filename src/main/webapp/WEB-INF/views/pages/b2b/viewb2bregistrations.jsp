<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title"><b>View B2B Registrations</b></h3>
			<div class="box-tools pull-right">
			</div>
		</div>
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="12%">Id</th>
						<th width="13%">Name</th>
						<th width="10%">Reg No</th>
						<th width="10%">Reg Type</th>
						<th width="10%">Code</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${b2bregs}" var="b2breg">
						<tr>
							<td>${b2breg.id}</td>
							<td>${b2breg.name}</td>
							<td>${b2breg.regNum}</td>
							<td>
								<c:choose>
									<c:when test="${b2breg.regType == 'LABIN'}">Lab Inward</c:when>
									<c:when test="${b2breg.regType == 'LABOUT'}">Lab Outward</c:when>
									<c:when test="${b2breg.regType == 'DR'}">Doctor</c:when>
									<c:otherwise>Franchise</c:otherwise>
								</c:choose>
							</td>
							<td>${empty b2breg.code ? '--' : b2breg.code}</td>
							<td><div class="box-tools pull-center">
									<a href="${pageContext.request.contextPath}/b2b/edit-b2b-registration/${b2breg.id}/${b2breg.regType}"><button type="button"
											class="btn btn-sm btn-info btn-box-tool">
											<i class="fa fa-edit" style="color: white"></i>
										</button> </a>
										<button type="button" class="btn btn-xs btn-toggle active" data-toggle="button" aria-pressed="true">
        									<div class="handle"></div>
      									</button>
      									
      									<a href="#"><button
											type="button" class="btn btn-sm btn-danger btn-box-tool">
											<i class="fa fa-times" style="color: white"></i>
										</button> </a> 

								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Model start  -->
		<div class="modal fade" id="lab-modal"">
			<div class="modal-dialog">
				<form method="POST" id="lab-form">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Lab</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Lab Type :</label><select name="state_id" id="stateId"
										class="form-control">
										<option value="">----select----</option>
										<option value="INWARD">Inward</option>
										<option value="OUTWARD">Outward</option>
									</select>
								</div>
								<div class="form-group col-sm-6">
									<label>Lab Code :</label> <input type="text" id="lab_code"
										name="lab_code" class="form-control" />
								</div>

								<div class="form-group col-sm-6">
									<label>Name :</label><input name="name" id="name"
										class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Registration Number :</label><input name="reg_num"
										id="reg_num" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Contact :</label><input name="contact" id="contact"
										class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Alternate Contact :</label><input name="alt_contact"
										id="alt_contact" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Email :</label><input name="email" id="email"
										class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Alternate Email :</label><input name="alt_email"
										id="alt_email" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Address :</label><input name="address" id="address"
										class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>City :</label> <select name="city_id" id="cityId"
										class="form-control">
										<option value="">----SELECT City----</option>
									</select>
								</div>
							<div class="form-group col-sm-6">
								<label>Pincode :</label><input name="pincode" id="pincode"
									class="form-control" />
							</div>
							<div class="form-group col-sm-6">
								<label>State :</label><select name="state_id" id="stateId"
									class="form-control">
									<option value="">----SELECT State----</option>
								</select>
							</div>
							<div class="form-group col-sm-6">
								<label>Managed By :</label><select name="manage_by"
									id="manage_by" class="form-control">
									<option value="">----SELECT MANAGED BY----</option>
								</select>
							</div>
							<div class="form-group col-sm-6">
								<label>Website :</label><input name="website" id="website"
									class="form-control" />
							</div>
							<div class="form-group col-sm-6">
								<label>Remark :</label><input name="remark" id="remark"
									class="form-control" />
							</div>
							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="" class="btn btn-primary">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
</section>