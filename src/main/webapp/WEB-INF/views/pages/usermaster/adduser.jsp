
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Add New User</h3>
			<div class="box-tools pull-right">
			<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="View Appointments">
					<a href="${pageContext.request.contextPath}/user-master/view-users"><i class="fa fa-plus"></i>
						 View Users</a>
				</button>
			</div>
		</div>
		
		<form:form method="POST"
				action=""
				modelAttribute="user" autocomplete="off">
		<div class="row">
			<div class="box-body">
				<div class="form-group col-sm-3">
					<label for="Country Code">First Name :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Last Name :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Father/Spouse Name :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Gender :</label> 
					<form:select  path=""
						class="form-control">
						<form:option value="">--select--</form:option>
						<form:option value="">Male</form:option>
						<form:option value="">Female</form:option>
						<form:option value="">Transgender</form:option>
					</form:select>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">DOB :</label>
						<div class='input-group date' id='datetimepicker1'>
			               <form:input type='text' class="form-control" path="" />
            				   <span class="input-group-addon">
               					<span class="glyphicon glyphicon-calendar"></span>
               				   </span>
            			</div>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Contact :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Alternate Contact :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Email :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Adhar Card No :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">PAN Card No :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Other ID Card No :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>

				<div class="form-group col-sm-3">
					<label for="Country Code">Address :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">City :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>

				<div class="form-group col-sm-3">
					<label for="Country Code">Remarks :</label>
					<form:input type="text" path=""
						class="form-control"/>
				</div>
				<div class="form-group col-sm-3">
					<label for="Country Code">Role :</label> 
					<form:select  path=""
						class="form-control">
						<form:option value="">--select--</form:option>
						<form:option value="">Supervisor</form:option>
						<form:option value="">Executive</form:option>
						<form:option value="">Sales</form:option>
						<form:option value="">Flabo</form:option>
					</form:select>
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