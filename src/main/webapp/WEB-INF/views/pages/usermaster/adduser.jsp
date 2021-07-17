
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>Add New User</b>
			</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="View Appointments">
					<a href="${pageContext.request.contextPath}/user-master/view-users"><i
						class="fa fa-plus"></i> View Users</a>
				</button>
			</div>
		</div>
		<form:form method="POST" modelAttribute="user"
			action="${pageContext.request.contextPath}/user-master/add-new-user"
			autocomplete="off" onsubmit="return validateAddUser()">
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">First Name :</label>
						<form:input type="text" path="firstName" id="firstName"
							class="form-control" onkeypress="return isCharOnly(event)"/>
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Last Name :</label>
						<form:input type="text" path="lastName" id="lastName" onkeypress="return isCharOnly(event)"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Father/Spouse Name :</label>
						<form:input type="text" path="fatherSpouseName"
							id="fatherSpouseName" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Gender :</label>
						<form:select path="gender" id="gender" class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="M">Male</form:option>
							<form:option value="F">Female</form:option>
							<form:option value="T">Transgender</form:option>
						</form:select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="box-body">

					<div class="form-group col-sm-3 has-feedback">
						<label for="Country Code">Date of birth :</label>
						<form:input type='text' class="form-control date-picker"
							path="dob" id="userDob" />
						<i class="fa fa-calendar form-control-feedback"></i>

					</div>
					<div class="form-group col-sm-3 has-feedback">
						<label for="Country Code">Date of joining :</label>
						<form:input type='text' class="form-control date-picker"
							path="doj" id="userDoj" />
						<i class="fa fa-calendar form-control-feedback"></i>

					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Contact :</label>
						<form:input type="text" path="mobileNo" id="mobileNo"
							class="form-control" onkeypress="return isNumberKey(event)"/>
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Alternate Contact :</label>
						<form:input type="text" path="alternateMobileNo"
							id="alternateMobileNo" class="form-control" />
					</div>

				</div>
			</div>
			<div class="row">
				<div class="box-body">

					<div class="form-group col-sm-3">
						<label for="Country Code">Email :</label>
						<form:input type="text" path="emailId" id="emailId"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Aadhar Card No :</label>
						<form:input type="text" path="adharCardNo" id="adharCardNo"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">PAN Card No :</label>
						<form:input type="text" path="panCardNo" id="panCardNo"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Other ID Card No :</label>
						<form:input type="text" path="otherIdCardNo" id="otherIdCardNo"
							class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Address Line1 : </label>
						<form:input type="text" path="address.addressLine1"
							id="addressLine1" class="form-control" placeholder="Room/Building/Society/Chawl name"/>
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Address Line2 :</label>
						<form:input type="text" path="address.addressLine2"
							id="addressLine2" class="form-control" placeholder="Street/Landmark/Area Location"/>
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">City :</label>
						<form:input type="text" path="address.city" id="city"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Pin code :</label>
						<form:input type="text" path="address.pinCode" id="pinCode"
							class="form-control" />
					</div>

				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">State :</label>
						<form:input type="text" path="address.state" id="state"
							class="form-control" />
					</div>

					<div class="form-group col-sm-3">
						<label for="Country Code">Country :</label>
						<form:input type="text" path="address.country" id="country"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Remarks :</label>
						<form:input type="text" path="remarks" id="remarks"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Role :</label>
						<form:select path="roleId" id="roleId" class="form-control">

							<form:option value="">--select--</form:option>
							<c:forEach items="${userRoleList}" var="userRoles">
								<form:option value="${userRoles.roleId}">${userRoles.roleName}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Reporting person :</label>
						<form:select type="text" path="reportingUserId" class="form-control">
								<form:option value="">----Select Reporting User----</form:option>
								<form:options items="${supervisorList}" itemValue="key"
									itemLabel="value" />
							</form:select>
						
					</div>

				</div>
			</div>



			<div class="box-footer">
				<div class="col-sm-12 col-sm-offset-5">
					<button type="submit" class="btn btn-primary" >
						<c:choose>
							<c:when test="${not empty user.id}">
								<form:hidden class="form-control" path="id" />
								<form:hidden class="form-control" path="address.addressId" />
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
		</form:form>


	</div>
</section>