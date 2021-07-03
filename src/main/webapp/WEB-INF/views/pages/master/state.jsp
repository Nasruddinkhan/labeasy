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
						data-target="#state-modal"> Add State</em>
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
						<th width="27%">Code</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${state}" var="state">
						<tr>
							<td>${state.stateId}</td>
							<td>${state.stateName}</td>
							<td>${state.countryDto.countryName}</td>
							<td><div class="box-tools pull-center">
									<a href="#"
										onclick="editState(${state.stateId},'${state.stateName}','${state.countryDto.countryId}')"><button
											type="button" class="btn btn-sm btn-info btn-box-tool">
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
		<div class="modal fade" id="state-modal" onload="countryLoad()">
			<div class="modal-dialog">
				<form method="POST" id="state-form">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add State</h4>
						</div>
						<input type="hidden" name="state_id" id="state_id" value="0">
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Name :</label> <input type="text" id="state_name"
										name="state_name" class="form-control" onkeypress="return isCharOnly(event)" />
								</div>
								<div class="form-group col-sm-6">
									<label>State Code :</label> <input type="text" id="state_code"
										name="state_code" class="form-control" onkeypress="return isCharOnly(event)"/>
								</div>
								<div class="form-group col-sm-6">
									<label id="country">Country :</label> countries <select
										name="countryId" class="form-control" id="country_id">
										<option value="">----SELECT Country----</option>
										<c:forEach items="${countries}" var="ct">
											<option value="${ct.countryId}">${ct.countryName}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addState()"
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