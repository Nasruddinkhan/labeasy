
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
									<th>Balance</th>
									<th >Action</th>
								</tr>
							</thead>
							<tbody>
								
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#">AP101</a></em></td>
										<td>Hamid khan</td>
										<td>9987353738</td>
										<td>30-Nov-2021 10:00 PM</td>
										<td><i class="fa fa-circle "></i> New</td>
										<td>Ramesh</td>
										<td>100</td>
										<td><div class="box-tools pull-center"> 
											<a href="#">
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
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#">AP102</a></em></td>
										<td>Wahid khan</td>
										<td>9987353453</td>
										<td>22-Dec-2021 09:00 AM</td>
										<td><i class="fa fa-user-md"></i> Assigned</td>
										<td>Mohan</td>
										<td>200</td>
										<td><div class="box-tools pull-center">
											<a href="#">
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
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#"><u>AP103</u></a></em></td>
										<td>Kadir khan</td>
										<td>9987353876</td>
										<td>13-Oct-2021 12:30 AM</td>
										<td><i class="fa fa-motorcycle"></i> Visiting</td>
										<td>Kundan</td>
										<td>150</td>
										<td><div class="box-tools pull-center">
												
											<a href="#">
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
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#"><u>AP103</u></a></em></td>
										<td>Kadir khan</td>
										<td>9987353876</td>
										<td>13-Oct-2021 12:30 AM</td>
										<td><i class="fa fa-medkit"></i> Collected</td>
										<td>Kundan</td>
										<td>150</td>
										<td><div class="box-tools pull-center">
												
											<a href="#">
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
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#"><u>AP103</u></a></em></td>
										<td>Kadir khan</td>
										<td>9987353876</td>
										<td>13-Oct-2021 12:30 AM</td>
										<td><i class="fa fa-hospital-o"></i> Dropped</td>
										<td>Kundan</td>
										<td>150</td>
										<td><div class="box-tools pull-center">
												
											<a href="#">
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
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#"><u>AP103</u></a></em></td>
										<td>Kadir khan</td>
										<td>9987353876</td>
										<td>13-Oct-2021 12:30 AM</td>
										<td><i class="fa fa-cog fa-spin"></i> Processing</td>
										<td>Kundan</td>
										<td>150</td>
										<td><div class="box-tools pull-center">
												
											<a href="#">
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
									<tr>
										<td><em data-toggle="modal" data-target="#appointment-status"><a href="#"><u>AP103</u></a></em></td>
										<td>Kadir khan</td>
										<td>9987353876</td>
										<td>13-Oct-2021 12:30 AM</td>
										<td><i class="fa fa-check-circle"></i> Tested</td>
										<td>Kundan</td>
										<td>150</td>
										<td><div class="box-tools pull-center">
												
											<a href="#">
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
									
								
							</tbody>
						</table>
					</div>
					
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