<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Add Inquiry</h3>
			<div class="box-tools pull-right">
			<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add inquriy">
					<em class="fa fa-plus" data-toggle="modal"
						data-target="#inquiry-modal"></em>
				</button>
			</div>
		</div>
		<div class="box-body">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>Inquiry Id</th>
									<th>Name</th>
									<th>Email</th>
									<th>Mobile No</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${inquires}" var="inq">
									<tr>
										<td>${inq.inqId}</td>
										<td>${inq.name}</td>
										<td>${inq.emailId}</td>
										<td>${inq.mobileNo}</td>
										<td><div class="box-tools pull-center">
												<a
													href="#"><button
														type="button" class="btn btn-sm btn-info btn-box-tool">
														<i class="fa fa-edit" style="color: white"></i>
													</button> </a> <a
													href="#"><button
														type="button" class="btn btn-sm btn-danger btn-box-tool">

														<i class="fa fa-trash" style="color: white"></i>
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
								<div class="form-group col-sm-6">
									<label >Name :</label> <input type="text" id="name"
										name="name" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label id="mobile_no">Mobile No :</label> <input
										type="text" name="mobile_no" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="form-group col-sm-6">
									<label for="Country Code">EmailId :</label> <input type="text" id="email_id"
										name="email_id" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label >Remarks :</label>
									<textarea name="remarks" id="remarks" rows="3" class="form-control"></textarea>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addInquiry()" class="btn btn-primary">Save</button>
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