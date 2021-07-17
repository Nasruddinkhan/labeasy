<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form method="POST" modelAttribute="appointmentdetails" onsubmit="return validateAppointmentForm()"
	action="${pageContext.request.contextPath}/appointment/add-appointment" autocomplete="off">
	<body
		onload="setOnLoadData('${appointmentdetails.appointmentId}', '${appointmentdetails.testList}', '${selectedTestName}')">
		<section class="content">
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">Appointment</h3>
					<div class="box-tools pull-right">
						<!-- click to open inquiry form  -->
						<button type="button" class="btn btn-box-tool"
							data-toggle="tooltip" title="View Appointments">
							<a href="${pageContext.request.contextPath}/appointment/view-appointment-page"><em
								class="fa fa-plus"></em> View Appointments</a>
						</button>
					</div>
				</div>
				<form:hidden path="testList" id="testList" class="form-control" />
				<form:hidden path="isWhatsappActive" id="isWhatsappActive" class="form-control"/> 
				<div class="box-body">
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Name :</label>
							<form:input type="text" path="name" id="name" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Age :</label>
							<form:input type="text" path="age" id="age" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Gender :</label>
							<form:select path="gender" id="gender" class="form-control">
								<form:option value="">----select----</form:option>
								<form:option value="M">Male</form:option>
								<form:option value="F">Female</form:option>
								<form:option value="T">Transgender</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Visit Type :</label>
							<form:select path="visitType" class="form-control " id="visit_type">
								<form:option value="N">Online Appointment</form:option>
								<form:option value="Y">Customer Visited</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Reffered by :</label>
							<form:input type="text" path="referredBy" id="referredBy" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Contact : </label>
							<button type="button" class="btn btn-xs btn-toggle active" data-toggle="button" id="whatsappActiveBtn"
							aria-pressed="true" style="margin:2px 0;" onclick="isWhatsappActiv()" title="Reports on whatsapp, if whatsapp active?">
        						<div class="handle"></div>
      						</button>
							<form:input type="text" id="contactNo" path="contactNo" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Alternate Contact :</label>
							<form:input type="text" id="alternateContactNo" path="alternateContactNo" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Email :</label>
							<form:input type="text" path="emailId" id="email" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-3">
							<label for="Country Code">Address Line1 :</label>
							<form:input type="text" path="addressLine1" id="room_no" class="form-control"
							 placeholder="Room/Building/Society/Chawl name"/>
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Address Line2 :</label>
							<form:input type="text" path="addressLine2"
								id="addressLine2" class="form-control" placeholder="Street/Landmark/Area Location"/>
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">City :</label>
							<form:input type="text" path="cityId" id="city" class="form-control" />
						</div>	
						<div class="form-group col-sm-3">
							<label for="Country Code">Pincode :</label>
							<form:input type="text" path="pinCode" id="pinCode" class="form-control" />
						</div>	
					</div>
				<div class="row">
					<div class="form-group col-sm-3">
							<label for="Country Code">Region :</label>
							<form:select path="region" class="form-control " id="region">
								<form:option value="">----select----</form:option>
								<form:option value="Central">Central</form:option>
								<form:option value="Western">Western</form:option>
								<form:option value="Harbour">Harbour</form:option>
								<form:option value="Suburban">Suburban</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-9">
							<label for="Country Code">Remarks (reason for test) :</label>
							<form:textarea type="text" path="remarks" class="form-control" id="remarks" />
						</div>
					</div>
					<div class="row">
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
							<form:input type="text" path="preferredLab" id="preferredLab" class="form-control" />
						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Appointment assign to :</label>
							<form:select type="text" path="assignTo" class="form-control" id="assign_to">
								<form:option value="">----select----</form:option>
								<form:options items="${phlebotomistList}" itemValue="key"
									itemLabel="value" />
							</form:select>

						</div>
						<div class="form-group col-sm-3">
							<label for="Country Code">Payment mode :</label>
							<form:select path="addInvoiceDto.paymentMode"
								class="form-control " id="payment">
								<form:option value="">----select----</form:option>
								<form:option value="O">Online</form:option>
								<form:option value="F">Offline</form:option>
							</form:select>
						</div>

				</div>


				<div class="row">
					<div class="box-body">
						<div class="form-group col-sm-8">
							<table 
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
												onclick="selectTest(${testName.price},${testName.testId},'${testName.name}' );" />
												${testName.name}</td>
											<td>${testName.testcode}</td>
											<td>${testName.price}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>

						<div class="form-group col-sm-4">
							<div class="row">
								<div class="box-body">
									<div class="col-sm-12">
										<div class="form-group col-sm-6">
											<label for="Country Code" style="font-size: 11px;">Selected
												Test <a class="viewtest"><i style="cursor: pointer;"
													onclick="testItems();" class="fa fa-eye" aria-hidden="true"></i></a>:
											</label>


											<form:input type="text" path="" id="selected_test"
												class="form-group form-control" readonly="true" value="0" />
										</div>
										<div class="form-group col-sm-6">

											<label for="Country Code" style="font-size: 11px;">Total
												Amt:</label>
											<form:input type="text" path="addInvoiceDto.totalAmount"
												id="total_amt" class="form-group form-control"
												readonly="true" />
										</div>
										<div class="form-group col-sm-6">
											<label for="Country Code" style="font-size: 11px;">Discount
												(if any):</label>
											<form:input type="text" path="addInvoiceDto.discountAmount"
											
												id="discount" onkeyup="discountAndPaidAmmount(this);"
												class="form-group form-control" />
										</div>

										<div class="form-group col-sm-6">
											<label for="Country Code" style="font-size: 11px;">Paid
												Amount:</label>
											<form:input type="text"
												onkeyup="discountAndPaidAmmount(this)"
												path="addInvoiceDto.advancePayment" id="paid_amt"
												class="form-group form-control" />

										</div>
										
			<!-- 
										<div class="form-group col-sm-12">
											<div id="percentageslider"></div>
											<p>
												% <span id="percentag-value"></span>
											</p>
										</div> -->
										<div class="form-group col-sm-12">
											<label for="Country Code" style="font-size: 11px;">Discount
												Reason amount :</label>
											<form:input type="text" path="addInvoiceDto.discountReason"
												class="form-group form-control" />
										</div>
										<div class="form-group col-sm-12">
											<label for="Country Code" style="font-size: 11px;">Balance
												amount :</label>
											<form:input type="text" path="addInvoiceDto.dueAmount"
												id="balance_id" class="form-group form-control"
												readonly="true" />
										</div>
											<%--<div class="form-group col-sm-12">
											<label for="Country Code" style="font-size: 11px;">isEmailWhatsapp:</label>
											 <form:checkbox path="addInvoiceDto.isEmailWhatsapp"
												 class="form-group form-control"
												/> --%>
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
								<c:when test="${not empty appointmentdetails.appointmentId}">
									<form:hidden class="form-control" path="appointmentId" />
									<form:hidden class="form-control"
										path="addInvoiceDto.billingId" />
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
			<div class="modal fade" id="select-test-modal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Selected Test</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="box-body">
									<table class="table table-sm table-bordered table-striped">
										<thead>
											<tr>
												<th>Test Name</th>
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
		</section>
	</body>
</form:form>
