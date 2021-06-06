
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title"><b>Change Password</b></h3>
		</div>
		<form:form method="POST"  modelAttribute="user"
				action=""
			autocomplete="off">
		
		<div class="row">
			<div class="box-body">
				
				<div class="form-group col-sm-4">
					<label for="Country Code">New password :</label>
					<form:input type="text" path="" id="newpassword"
						class="form-control"/>
				</div>
				<div class="form-group col-sm-8">
				</div>
			</div>
		</div>
			
		<div class="row">
			<div class="box-body">
				<div class="form-group col-sm-4">
					<label for="Country Code">Confirm new password :</label>
					<form:input type="text" path="" id="confirmnewpassword"
						class="form-control"/>
				</div>
				<div class="form-group col-sm-8">
				</div>
			</div>
		</div>	
		
				
			
		<div class="box-footer">
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
				<div class="form-group col-sm-8">
				</div>
			</div> 
		<!-- /.box-body -->
	</form:form>
	
	
	</div>
</section>