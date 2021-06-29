
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>Add New Doctor</b>
			</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="View Doctors">
					<a href="${pageContext.request.contextPath}/doctor-master/view-doctors"><i
						class="fa fa-plus"></i> View Users</a>
				</button>
			</div>
		</div>
		<form:form method="POST" modelAttribute="doctor"
			action="${pageContext.request.contextPath}/doctor-master/add-doctor"
			autocomplete="off">
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Prefix">PreFix :</label>
						<form:select path="prefix" id="prefix" class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="DR">DR</form:option>
							<form:option value="MR">MR</form:option>
							<form:option value="LAB">LAB</form:option>
							<form:option value="HOSPITAL">HOSPITAL</form:option>
						</form:select>
					</div>
					<div class="form-group col-sm-3">
						<label for="Name"> Name :</label>
						<form:input type="text" path="name" id="name" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="speciality">Speciality :</label>
						<form:select path="speciality" id="speciality"
							class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="Dermatologists">Dermatologists</form:option>
							<form:option value="Endocrinologists">Endocrinologists</form:option>
							<form:option value="Geriatric Medicine">Geriatric Medicine</form:option>
							<form:option value="Gastroenterologists">Gastroenterologists</form:option>
						</form:select>
					</div>
					<div class="form-group col-sm-3">
						<label for="registrationid">Registration Id :</label>
						<form:input type="text" path="registrationId" id="registrationId"
							class="form-control" />
					</div>

				</div>
			</div>

			<div class="row">
				<div class="box-body">

					<div class="form-group col-sm-3">
						<label for="Contact">Contact :</label>
						<form:input type="text" path="mobileNo" id="mobileNo"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Alternate Contact">Alternate Contact :</label>
						<form:input type="text" path="alternateMobileNo"
							id="alternateMobileNo" class="form-control" />
					</div>
					<div class="form-group col-sm-3 has-feedback">
						<label for="email">Email :</label>
						<form:input type='text' class="form-control" path="emailId"
							id="emailId" />
					</div>
					<div class="form-group col-sm-3 has-feedback">
						<label for="Alternate Email">Alternate Email :</label>
						<form:input type='text' class="form-control"
							path="alternateEmailId" id="alternateEmailId" />
					</div>

				</div>
			</div>

			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Address:</label>
						<form:input type="text" path="address" id="address"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">City :</label>
						<form:input type="text" path="city" id="city" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Pin code :</label>
						<form:input type="text" path="pincode" id="pinCode"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">State :</label>
						<form:input type="text" path="state" id="state"
							class="form-control" />
					</div>


				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Web Site">Incentice Percentage :</label>
						<form:input type="text" path="incenticePercentage"
							id="incenticePercentage" class="form-control" />
					</div>
					<div class="form-group col-sm-3">

						<label for="Managed By">Managed By :</label>
						<form:select path="managedBy" id="managedBy" class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="A">Managed A</form:option>
							<form:option value="B">Managed B</form:option>
							<form:option value="C">Managed C</form:option>
							<form:option value="D">Managed D</form:option>
						</form:select>
					</div>
					<div class="form-group col-sm-3">
						<label for="Web Site">Web Site :</label>
						<form:input type="text" path="webSite" id="webSite"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Remarks :</label>
						<form:input type="text" path="remarks" id="remarks"
							class="form-control" />
					</div>

				</div>
				<div class="box-footer">
				<div class="col-sm-12 col-sm-offset-5">
					<button type="submit" class="btn btn-primary">
						<c:choose>
							<c:when test="${not empty doctor.id}">
								<form:hidden class="form-control" path="id" />
									Update 
							</c:when>
							<c:otherwise>
								Save
							</c:otherwise>
						</c:choose>
					</button>
				</div>
			</div>
			</div>
		</form:form>


	</div>
</section>