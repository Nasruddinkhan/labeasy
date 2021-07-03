<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">City</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool">
					<em class="fa fa-plus" data-toggle="modal"
						data-target="#city-modal"> Add City</em>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="12%">Id</th>
						<th width="13%">Name</th>
						<th width="10%">State</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cities}" var="city">
						<tr>
					
							<td>${city.cityId}</td>
							<td>${city.cityName}</td>
							<td>${city.stateDto.stateName}</td>
							<td><div class="box-tools pull-center">
									<a href="#"><button type="button"
											class="btn btn-sm btn-info btn-box-tool" onclick="cityEdit(${city.cityId},${city.countryDto.countryId},'${city.cityName}','${city.stateDto.stateId}')">
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
		<div class="modal fade" id="city-modal"">
			<div class="modal-dialog">
				<form method="POST" id="city-form">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add City</h4>
						</div>
						<input type="hidden" id="city_id" name="city_id">
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">

									<label>Name :</label> <input type="text" id="name"
										name="city_name" class="form-control"
										onkeypress="return isCharOnly(event)" />

								</div>

								<div class="form-group col-sm-6">
									<label>Country :</label><select name="country_id"
										id="countryId" class="form-control"
										onchange="viewState($('#countryId').val())">
										<option value="">----SELECT Country----</option>
										<c:forEach items="${countries}" var="ct">
											<option value="${ct.countryId}">${ct.countryName}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-sm-6">
									<label>State :</label><select name="state_id" id="stateId"
										class="form-control">
										<option value="">----SELECT State----</option>
										<%-- <c:forEach items="${countries}" var="ct">
											<option value="${ct.countryId}">${ct.countryName}</option>
										</c:forEach> --%>
									</select>
								</div>

							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addCity()" class="btn btn-primary">Save</button>
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