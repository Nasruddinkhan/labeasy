
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form method="POST" modelAttribute="appointment"
	action="${pageContext.request.contextPath}/appointment/add-appointment"
	autocomplete="off">
	<body
		onload="setOnLoadData('${appointment.appointmentId}', '${appointment.testList}')">
		<section class="content">
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">Appointment</h3>
					<div class="box-tools pull-right">
						<!-- click to open inquiry form  -->
						<button type="button" class="btn btn-box-tool"
							data-toggle="tooltip" title="View Appointments">
							<a
								href="${pageContext.request.contextPath}/appointment/view-appointment-page"><i
								class="fa fa-plus"></i> View Appointments</a>
						</button>
					</div>
				</div>


				<form:hidden path="testList" id="testList" class="form-control" />

				<div class="box-body">
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Name :</label>
							<form:input type="text" path="name" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Age :</label>
							<form:input type="text" path="age" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Gender :</label>
							<form:select path="gender" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="M">Male</form:option>
								<form:option value="F">Female</form:option>
								<form:option value="T">Transgender</form:option>
							</form:select>
						</div>

						<div class="form-group col-sm-3">
							<label for="Country Code">Mobile :</label>
							<form:input type="text" path="mobileNo" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Reffered by :</label>
							<form:input type="text" path="reffredBy" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Email :</label>
							<form:input type="text" path="emailId" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Address :</label>
							<form:input type="text" path="address" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">City :</label>
							<form:input type="text" path="cityId" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Room No :</label>
							<form:input type="text" path="roomNoBldNo" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Area Location Street :</label>
							<form:input type="text" path="areLocStreetName"
								class="form-control" />
						</div>
						<div class="form-group col-sm-6">
							<label for="Country Code">Remarks (reason for test) :</label>
							<form:textarea type="text" path="remarks" class="form-control" />
						</div>
					</div>
				</div>


				<div class="row">
					<div class="box-body">
						<div class="form-group col-sm-2">
							<label for="Country Code">Appointment date :</label>
							<div class="input-group">
								<form:input type="text" class="form-control pull-right"
									path="appointmentDate" id="appointmentDate" />
							</div>
						</div>
						<div class="form-group col-sm-1">
							<label for="Country Code"> Time :</label>
							<div class="input-group bootstrap-timepicker">

								<form:input type="text"
									class="form-control pull-right timepicker"
									path="appointmentTime" id="appointmentTime" />
							</div>
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Test preferred Lab :</label>
							<form:input type="text" path="prefredLab" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Appointment assign to :</label>
							<form:input type="text" path="assignTo" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Payment mode :</label>
							<form:select path="andInvoiceDto.paymentMode"
								class="form-control ">
								<form:option value="">--select--</form:option>
								<form:option value="O">Online</form:option>
								<form:option value="F">Offline</form:option>
							</form:select>
						</div>

					</div>
				</div>


				<div class="row">
					<div class="box-body">
						<div class="form-group col-sm-9">
							<table id="testDatatable"
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

											<td><input type="checkbox" id="test${testName.testId}"
												onclick="selectTest(${testName.price},${testName.testId});" />
												${testName.name}</td>
											<td>${testName.testcode}</td>
											<td>${testName.price}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>

						<div class="form-group col-sm-3">
							<div class="row">
								<div class="box-body">
									<div class="col-sm-12">
										<div class="form-group col-sm-6">
											<label for="Country Code" style="font-size: 11px;">Selected
												Test:</label>
											<form:input type="text" path="" id="selected_test"
												class="form-group form-control" readonly="true" value="0" />
										</div>
										<div class="form-group col-sm-6">

											<label for="Country Code" style="font-size: 11px;">Total
												Amt:</label>
											<form:input type="text" path="andInvoiceDto.totalAmmount"
												id="total_amt" class="form-group form-control"
												readonly="true" />
										</div>
										<div class="form-group col-sm-6">
											<label for="Country Code" style="font-size: 11px;">Discount
												(if any):</label>
											<form:input type="text" path="andInvoiceDto.discountAmmount"
												id="discount" onkeyup="discountAndPaidAmmount(this);"
												class="form-group form-control" />
										</div>
										<div class="form-group col-sm-6">
											<label for="Country Code" style="font-size: 11px;">Paid
												Amount:</label>
											<form:input type="text"
												onkeyup="discountAndPaidAmmount(this)"
												path="andInvoiceDto.advancePayment" id="paid_amt"
												class="form-group form-control" />

										</div>

										<div class="form-group col-sm-12">
											<label for="Country Code" style="font-size: 11px;">Discount
												Reason amount :</label>
											<form:input type="text" path="andInvoiceDto.discountReason"
												class="form-group form-control" />
										</div>
										<div class="form-group col-sm-12">
											<label for="Country Code" style="font-size: 11px;">Balance
												amount :</label>
											<form:input type="text" path="andInvoiceDto.paymentAmmount"
												id="balance_id" class="form-group form-control"
												readonly="true" />
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="box-footer">
					<div class="col-sm-12 col-sm-offset-5">

						<button type="submit" class="btn btn-primary">
							<c:choose>
								<c:when test="${not empty appointment.appointmentId}">
									<form:hidden class="form-control" path="appointmentId" />
									<form:hidden class="form-control"
										path="andInvoiceDto.billingId" />
									<form:hidden class="form-control" path="createdDate" />
									<form:hidden class="form-control" path="createdBy" />
					Update 
					</c:when>
								<c:otherwise>
					Save
					</c:otherwise>
							</c:choose>

						</button>
					</div>
				</div>
				<!-- /.box-body -->



			</div>
		</section>
	</body>
</form:form>