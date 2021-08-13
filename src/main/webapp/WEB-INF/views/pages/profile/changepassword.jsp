
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>Change Password</b>
			</h3>
			<div class="box-tools pull-right">
				
			</div>
		</div>
		<form:form method="POST" modelAttribute="user"
			action="${pageContext.request.contextPath}/user-profile/change-password"
			autocomplete="off">
			<div class="row">
				<div class="box-body">
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-2">
						<label for="Country Code">New Password :</label>
						
					</div>
					<div class="form-group col-sm-4">
						<form:input type="text" path="password" id="password"
							class="form-control" />
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-2">
						<label for="Country Code">Re-Enter New Password :</label>
					</div>
					<div class="form-group col-sm-4">
						<form:input type="text" path="rePassword" id="rePassword"
							class="form-control" />
					</div>
				</div>
			</div>

			<div class="box-footer">
				<div class="col-sm-6 col-sm-offset-2">
					<button type="submit" class="btn btn-primary" >
						Change Password
					</button>
				</div>
			</div>
		</form:form>


	</div>
</section>