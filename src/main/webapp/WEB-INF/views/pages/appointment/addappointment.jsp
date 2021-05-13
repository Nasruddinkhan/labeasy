
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Add Appointment</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="View Appointments">
					<a
						href="${pageContext.request.contextPath}/appointment/view-appointment-page"><i
						class="fa fa-plus"></i> View Appointments</a>
				</button>
			</div>
		</div>

		<form:form method="POST" action="" modelAttribute="appointment"
			autocomplete="off">
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Name :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Age :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Gender :</label>
						<form:select path="" class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="">Male</form:option>
							<form:option value="">Female</form:option>
							<form:option value="">Transgender</form:option>
						</form:select>
					</div>

					<div class="form-group col-sm-3">
						<label for="Country Code">Mobile :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Reffered by :</label>
						<%-- <form:select  path=""
						class="form-control">
						<form:option value="">--select--</form:option>
						<form:option value="">Select</form:option>
						<form:option value="">Ramesh</form:option>
						<form:option value="">Rohan</form:option>
						<form:option value="">Rajesh</form:option>
					</form:select> --%>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Email :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Address :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">City :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<%-- <div class="form-group col-sm-3">
					<label for="Country Code">Pincode :</label>
					<form:input type="text" path=""
						class="form-control" readonly="true"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">State :</label>
					<form:input type="text" path=""
						class="form-control" readonly="true"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Country :</label>
					<form:input type="text" path=""
						class="form-control" readonly="true"/>
				</div> --%>
					<div class="form-group col-sm-12">
						<label for="Country Code">Remarks (reason for test) :</label>
						<form:textarea type="text" path="" class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<%-- <div class="form-group col-sm-3">
					<label for="Country Code">Test Group :</label> 
					<form:select  path=""
						class="form-control" disabled="true">
						<form:option value="">--select--</form:option>
						<form:option value="">All</form:option>
						<form:option value="">Test Group1</form:option>
						<form:option value="">Test Group2</form:option>
						<form:option value="">Test Group3</form:option>
					</form:select> 			
				</div>	
				<div class="form-group col-sm-3">
					<label for="Country Code">Test Package :</label> 
					<form:select  path=""
						class="form-control" disabled="true">
						<form:option value="">--select--</form:option>
						<form:option value="">Test Package1</form:option>
						<form:option value="">Test Package2</form:option>
						<form:option value="">Test Package3</form:option>
					</form:select> 			
				</div> --%>
					<div class="form-group col-sm-3">
						<label for="Country Code">Appointment date&time :</label>
						<div class='input-group date' id='datetimepicker1'>
							<form:input type='text' class="form-control" path="" />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Test preferred Lab :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Appointment assign to :</label>
						<form:input type="text" path="" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Payment mode :</label>
						<form:select path="" class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="">Online</form:option>
							<form:option value="">Card</form:option>
							<form:option value="">Cash</form:option>
						</form:select>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-9">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>Test Name</th>
									<th>Test Code</th>
									<th>Cost</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${testNameList}" var="testName">
									<tr>

										<td><form:checkbox path="" value="" /> ${testName.name}</td>
										<td>${testName.testcode}</td>
										<td>${testName.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

					<div class="form-group col-sm-3">
						<%-- <label for="Country Code">Number of group selected :</label>
					<form:input type="text" path=""
						class="form-group form-control" readonly="true" value="0"/> --%>
						<div class="row">
							<div class="box-body">
								<div class="col-sm-12">
									<div class="form-group col-sm-6">
										<label for="Country Code" style="font-size: 11px;">Selected Test:</label>
										<form:input type="text" path=""
											class="form-group form-control" readonly="true" value="0" />
									</div>
									<div class="form-group col-sm-6">

										<label for="Country Code" style="font-size: 11px;">Total Amt:</label>
										<form:input type="text" path=""
											class="form-group form-control" readonly="true" value="0" />
									</div>
									<div class="form-group col-sm-6">
										<label for="Country Code" style="font-size: 11px;">Discount (if any):</label>
										<form:input type="text" path=""
											class="form-group form-control" />
									</div>
									<div class="form-group col-sm-6" >
										<label for="Country Code" style="font-size: 11px;">Paid Amount:</label>
										<form:input type="text" path=""
											class="form-group form-control" />

									</div>
									<div class="form-group col-sm-12">
										<label for="Country Code"  style="font-size: 11px;">Balance amount :</label>
										<form:input type="text" path=""
											class="form-group form-control" readonly="true" value="0" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			 <div class="box-footer">
				<div class="col-sm-12 col-sm-offset-5">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div> 
			<!-- /.box-body -->
		</form:form>


	</div>
</section>