<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>Test Package</b>
			</h3>
			<div class="box-tools pull-right">
			</div>
		</div>
		
		<div class="box-body">
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-4">
						<label for="Country Code">Package Code :</label>
						<input type="text" class="form-control">
					</div>
					
					<div class="form-group col-sm-4">
						<label for="Country Code">Package Name :</label>
						<input type="text" class="form-control">
					</div>
					
					<div class="form-group col-sm-4">
						<label for="Country Code">Status :</label>
						<select  class="form-control">
							<option>---select---</option>
							<option>Active</option>
							<option>In-Active</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-12">
						<table class="table table-sm table-bordered table-striped" id="example1">
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
				</div>
			</div>
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-4">
						<label for="Country Code">Actual Price :</label>
						<input type="text" disabled="disabled" class="form-control">
					</div>
					<div class="form-group col-sm-4">
						<label for="Country Code">Discount :</label>
						<input type="text" class="form-control">
					</div>
					<div class="form-group col-sm-4">
						<label for="Country Code">Final Price :</label>
						<input type="text" disabled="disabled" class="form-control">
					</div>
				</div>
			</div>
				<div class="row">
					<div class="box-body">
						<div class="form-group col-sm-12">
							<label for="Country Code">Description :</label>
							<textarea class="form-control"></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-sm-offset-5">
				<button type="button" class="btn btn-sm  btn-primary">Save</button>
			</div>
		</div>
</section>
