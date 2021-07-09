
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Test Names</h3>
			<div class="box-tools pull-right">
				<!-- click to open inquiry form  -->
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Add Test Name">
					<em class="fa fa-plus" data-toggle="modal" data-target="#test-name">
						Add Test Name</em>
				</button>





			</div>
		</div>
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="10%">Test Id</th>
						<th width="13%">Test Code</th>
						<th>Test Name</th>
						<th width="10%">Price</th>
						<th width="13%">B2B Price</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${testNameList}" var="testName">
						<tr>
							<td>${testName.testId}</td>
							<td>${testName.testcode}</td>
							<td>${testName.name}</td>
							<td>${testName.price}</td>
							<td>${testName.b2bprice}</td>
							<td><div class="box-tools pull-center">
									<a href="#"><button type="button"
											class="btn btn-sm btn-info btn-box-tool">
											<i class="fa fa-edit" style="color: white"></i>
										</button> </a> <a href="#"><button type="button"
											class="btn btn-sm btn-danger btn-box-tool">

											<i class="fa fa-trash" style="color: white"></i>
										</button> </a>

								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Model start  -->
		<div class="modal fade" id="test-name">
			<div class="modal-dialog">
				<form method="POST" id="add-test-form" autocomplete="off">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Test Name</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Test Group :</label> <select id="groupId" name="groupId"
										class="form-control" disabled="disabled">
										<option>--Select--</option>
										<c:forEach items="${testGroupList}" var="testGroup">
											<option value='${testGroup.groupId}'>${testGroup.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-6">
									<label for="Country Code">Test Code :</label> <input
										type="text" id="testcode" name="testcode" class="form-control" />
								</div>
							</div>
							<div class="row">

								<div class="form-group col-sm-6">
									<label>Test Name :</label> <input type="text" id="name"
										name="name" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label for="Country Code">Description :</label> <input
										type="text" id="description" name="description"
										class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label>Price :</label> <input type="text" id="price"
										name="price" class="form-control"
										onkeypress="return isNumberKey(event)" />
								</div>
								<div class="form-group col-sm-6">
									<label for="Country Code">B2B Price :</label> <input
										type="text" id="b2bprice" name="b2bprice" class="form-control"
										onkeypress="return isNumberKey(event)" />
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addTestName()"
								class="btn btn-primary">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
</section>