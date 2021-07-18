
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>Add New Lab</b>
			</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="View B2B Registrations">
					<a href="${pageContext.request.contextPath}/b2b/view-b2b-registration"><i
						class="fa fa-plus"></i> View B2B Registrations</a>
				</button>
			</div>
		</div>
		<form:form method="POST" modelAttribute="b2breg"
			action="${pageContext.request.contextPath}/b2b/add-lab-registration"
			autocomplete="off">
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
							<label for="Country Code">Lab Type :</label>
							<form:select path="regType" id="regType" class="form-control">
								<form:option value="">----select----</form:option>
								<form:option value="LABIN">Inward</form:option>
								<form:option value="LABOUT">Outward</form:option>
							</form:select>
						</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Lab Code :</label>
						<form:input type="text" path="code" id="code"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Name :</label>
						<form:input type="text" path="name" id="name"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Registration Number :</label>
						<form:input type="text" path="regNum" id="regNum" class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">ID Card No :</label>
						<form:input type="text" path="idCardNo" id="idCardNo" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Other ID Card No (if any) :</label>
						<form:input type="text" path="otherIdCardNo" id="otherIdCardNo" class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Contact :</label>
						<form:input type="text" path="contactNo" id="contactNo"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Alternate Contact :</label>
						<form:input type="text" path="alternateContactNo"
							id="alternateContactNo" class="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Email :</label>
						<form:input type="text" path="email" id="email"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Alternate Email :</label>
						<form:input type="text" path="alternateEmail" id="alternateEmail"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Address Line1 : </label>
						<form:input type="text" path="addressLine1"
							id="addressLine1" class="form-control" placeholder="Room/Building/Society/Chawl name"/>
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Address Line2 :</label>
						<form:input type="text" path="addressLine2"
							id="addressLine2" class="form-control" placeholder="Street/Landmark/Area Location"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">City :</label>
						<form:input type="text" path="city" id="city"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">Pin code :</label>
						<form:input type="text" path="pinCode" id="pinCode"
							class="form-control" />
					</div>
					<div class="form-group col-sm-3">
						<label for="Country Code">State :</label>
						<form:input type="text" path="state" id="state"
							class="form-control" />
					</div>

					<div class="form-group col-sm-3">
						<label for="Country Code">Country :</label>
						<form:input type="text" path="country" id="country"
							class="form-control" />
					</div>
				</div>
			</div>	
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Website :</label>
						<form:input type="text" path="website" id="website"
							class="form-control" />
					</div>
					<div class="form-group col-sm-9">
						<label for="Country Code">Remarks :</label>
						<form:textarea type="text" path="remarks" class="form-control" id="remarks" />
					</div>
				</div>
			</div>
			<div class="box-footer">
				<div class="col-sm-12 col-sm-offset-5">
					<button type="submit" class="btn btn-primary" >
						<c:choose>
							<c:when test="${not empty b2breg.id}">
								<form:hidden path="id" />
								<form:hidden path="updatedDate" />
								<form:hidden path="updatedBy" />
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