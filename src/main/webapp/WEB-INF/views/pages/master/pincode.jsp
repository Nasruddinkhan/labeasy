<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">States</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool">
					<em class="fa fa-plus" data-toggle="modal"
						data-target="#pincode-modal"> Add PinCode</em>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="12%">Id</th>
						<th width="13%">Pin Code</th>
						<th width="27%">Area Name</th>
						<th width="27%">City</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pincodes}" var="pin">
						<tr>
							<td>${pin.pinId}</td>
							<td>${pin.pinCode}</td>
							<td>${pin.areaName}</td>
							<td>${pin.cityDto.cityName}</td> 
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
		<div class="modal fade" id="pincode-modal">
			<div class="modal-dialog">
				<form method="POST" id="pincode-form">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add PinCode</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Pin Code :</label> <input type="text" id="pincode"
										name="pin_code" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label id="area_name">Area Name :</label> <input type="text"
										name="area_name" class="form-control" />
								</div>
								<div class="form-group col-sm-6">
									<label id="country">Country :</label> <select name="countryId" id="countryId"
										class="form-control"  onchange="viewState($('#countryId').val())">
										<option value="">----SELECT Country----</option>
										<c:forEach items="${countries}" var="ct">
											<option value="${ct.countryId}">${ct.countryName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-6">
									<label id="country">State :</label> <select name="stateId" id="stateId"
										class="form-control" onchange="viewCity($('#stateId').val())">
										<option value="">----SELECT State----</option>
									</select>
								</div>
								<div class="form-group col-sm-6">
									<label id="country">City :</label> <select name="city_id" id="cityId"
										class="form-control">
										<option value="">----SELECT City----</option>
									</select>
								</div>
							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addPinCode()"
								class="btn btn-primary">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
</section>