
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title"> Appointments</h3>
			<div class="box-tools pull-right">
			<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add Appointment">
					<li><a href="${pageContext.request.contextPath}/appointment/add-apointment"><i class="fa fa-plus"></i>
						Add Appointment</a></li>
				</button>
			</div>
		</div>
		<div class="box-body">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>Sr Id</th>
									<th>Name</th>
									<th>Email</th>
									<th>Mobile No</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								
									<tr>
										<td>101</td>
									<td>Nasruddin khan</td>
									<td>Nasruddinkhan44@gmail.com</td>
									<td>9987353738</td>
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
								
							</tbody>
						</table>
					</div>
	</div>
</section>