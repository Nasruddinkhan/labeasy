<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Inquiries</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add inquriy">
					<em class="fa fa-plus" data-toggle="modal"
						data-target="#inquiry-modal"> Add Inquiry</em>
				</button>
			</div>
		</div>
		<div class="box-body">
		<div class="row">
			<div class="form-group col-sm-3">
				<label for="Country Code">Update Status :</label> <select
					name="status" class="form-control ">
					<option value="">--select--</option>
					<option value="AP">Phone Busy</option>
					<option value="SC">Phone ringing but not picking</option>
					<option value="SD">Phone not reachable</option>
					<option value="SE">Pending with other reason</option>
					<option value="SP">Closed</option>
				</select>
			</div>
			<div class="form-group col-sm-3">
				<label for="Country Code">Remarks :</label>
				<input type="text" name="remarks" id="remarks" class="form-control" />
			</div>
			<div class="form-group col-sm-3">
				<button style="margin-top: 2em;" type="button"
					class="btn btn-sm btn-success">Update Status</button>
			</div>
		</div>
		</div>
		
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="12%">Inquiry Id</th>
						<th>Name</th>
						<th width="13%">Mobile No</th>
						<th width="27%">Email</th>
						<th >Status</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${inquires}" var="inq">
						<tr>
							<td><input type="checkbox" />  INQ${inq.inqId}</td>
							<td>${inq.name}</td>
							<td>${inq.mobileNo}</td>
							<td>${inq.emailId}</td>
							<td>${inq.status}</td>
							<td><div class="box-tools pull-center">
									<a href="#"><button type="button"
											class="btn btn-sm btn-info btn-box-tool"
											onclick="inquiryEdit(${inq.inqId},'${inq.name}','${inq.mobileNo}','${inq.emailId}','${inq.remarks}')">
											<i class="fa fa-edit" style="color: white"></i>
										</button> </a> 
										
										<a href="#"><button type="button"
											class="btn btn-sm btn-danger  btn-box-tool"
											onclick="activitiesHistory()">
											<i class="fa fa-clock-o" style="color: white"></i>
										</button> </a>
										
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Model start  -->
		<div class="modal fade" id="inquiry-modal">
			<div class="modal-dialog">
				<form method="POST" id="inqury-form">
					<input type="hidden" id="inq_id" name="inq_id">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Inquiry</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6 form-group required control-label">
									<label class="required">Name :</label> <input type="text" id="name" name="name"
										class="form-control form-group.required" onkeypress="return isCharOnly(event)" />
								</div>
								<div class="form-group col-sm-6">
									<label class="required">Mobile No :</label> <input type="text" name="mobile_no"
										id="mobile_no" class="form-control" maxlength="13"
										onkeypress="return isNumberKey(event)" />
								</div>
							</div>
							<div class="row">
								<div class="form-group col-sm-6">
									<label class="required" for="Country Code">EmailId :</label> <input type="text"
										id="email_id" name="email_id" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label class="required">Remarks :</label>
									<textarea name="remarks" id="remarks" rows="3"
										class="form-control"></textarea>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" id=inq_btn_add class="btn btn-primary"
								onclick="addInquiry()">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<div class="modal fade" id="activities-history-modal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Inquiry History</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="box-body">
									<table class="table table-sm table-bordered table-striped">
										<thead>
											<tr>
												<th width="20%">Activity Date</th>
												<th>Status</th>
												<th width="60%">Remarks</th>
											</tr>
										</thead>
										<tbody id="tbl">

										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
	</div>
</section>