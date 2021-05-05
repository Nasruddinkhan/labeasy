<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Add Inquiry</h3>
		</div>
		<form:form method="POST"
				action="${pageContext.request.contextPath}/inquiry/save-inquiry"
				modelAttribute="inquiry">
		<div class="row">
			<div class="box-body">
				<div class="form-group col-sm-4">
					<label for="Country Code">Name :</label>
					<form:input type="text" path="name"
						class="form-control"/>
				</div>
				<div class="form-group col-sm-4">
					<label for="Country Code">Mobile No :</label>
					<form:input type="text" path="mobileNo"
						class="form-control"/>
				</div>
				<div class="form-group col-sm-4">
					<label for="Country Code">Name :</label> 
					<form:input type="text" path="emailId"
						class="form-control"/>
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