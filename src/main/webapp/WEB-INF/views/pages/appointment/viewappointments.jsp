<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">View Appointments</h3>
			<div class="box-tools pull-right">
			<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add Appointment">
					<a href="${pageContext.request.contextPath}/appointment/show-appointment-page"><i class="fa fa-plus"></i>
						Add Appointment</a>
				</button>
			</div>
		</div>
		<c:if test="${not empty appointment}">
		<div class="box-body">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>Ap Id</th>
									<th>Name</th>
									<th>Mobile No</th>
									<th>Visit date time</th>
									<th>Status</th>
									<th>Assigned to</th>
									<th>NoOfTest</th>
									<th>Due Amount</th>
									<th>Balance</th>
									<th >Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${appointment}" var="app">
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status">
										<a href="#">AP ${app.appointmentId}</a></em></td>
										<td>${app.name}</td>
										<td>${app.mobileNo}</td>
										<td>${app.appointmentDate} - ${app.appointmentTime}</td>
										<td><i class="fa fa-circle "></i> New</td>
										<td>${app.assignTo}</td>
										<td>${app.testList}</td>
										<td>${app.andInvoiceDto.paymentAmmount}</td>
										<td>${app.andInvoiceDto.advancePayment}</td>
										<td><div class="box-tools pull-center"> 
											<a href="${pageContext.request.contextPath}/appointment/editAppointment/${app.appointmentId}">
											<button type="button" class="btn btn-sm btn-info btn-box-tool">
												<i class="fa fa-edit" style="color: white"></i>
											</button>
											</a>
											<a href="#"><button
												type="button" class="btn btn-sm btn-danger btn-box-tool">

												<i class="fa fa-trash" style="color: white"></i>
											</button> 
											</a>
											<a href="#">
											<button type="button" class="btn btn-sm btn-warning btn-box-tool">
												<i class="fa fa-upload" style="color: white"></i>
											</button>
											</a>
											<a href="#">
											<button type="button" class="btn btn-sm btn-success btn-box-tool">
												<i class="fa fa-whatsapp" style="color: white"></i>
											</button>
											</a>
											<a href="#">
											<button type="button" class="btn btn-sm btn-primary btn-box-tool">
												<i class="fa fa-envelope" style="color: white"></i>
											</button>
											</a>

											</div></td>
									</tr>
									</c:forEach>
									
								
							</tbody>
						</table>
					</div>
		</c:if>
					<!-- Model start  -->	
		<div class="modal fade" id="appointment-status">
			<div class="modal-dialog">
				<form method="POST" id="add-group-form">
					<div class="modal-content">
						
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Advance searches</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label >Appointment ID :</label> <input type="text" id="name"
										name="name" class="form-control"  autocomplete="off" readonly="readonly"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Name :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Mobile :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Email :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Status :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Reffered by :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Appointment scheduled date :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Appointment created date :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Total amount :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off" readonly="readonly"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Discount amount :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Pending balance :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								<div class="form-group col-sm-6">
									<label >Assigned to :</label> <input type="text" id="description"
										name="description" class="form-control"  autocomplete="off"/>
								</div>
								
							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="" class="btn btn-primary">Search</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
</section>