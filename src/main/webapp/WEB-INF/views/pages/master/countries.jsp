<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Countries</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool">
					<em class="fa fa-plus" data-toggle="modal"
						data-target="#country-modal"> Add Country</em>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table id="example1"
				class="table table-sm table-bordered table-striped">
				<thead>
					<tr>
						<th width="12%">Country Id</th>
						<th width="13%">Name</th>
						<th width="27%">Code</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${countries}" var="cont">
						<tr>
							<td>${cont.countryId}</td>
							<td>${cont.countryName}</td>
							<td>${cont.countryCode}</td>
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
		<div class="modal fade" id="country-modal">
			<div class="modal-dialog">
				<form method="POST" id="country-form">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Country</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-sm-6">
									<label>Name :</label> <input type="text" id="country_name"
										name="country_name" class="form-control"
										onkeypress="return isCharOnly(event)" />
								</div>
								<div class="form-group col-sm-6">
									<label>Country Code :</label> <input type="text"
										id="country_code" name="country_code" class="form-control"
										onkeypress="return isCharOnly(event)" />
								</div>
							</div>

							<!-- /.box-body -->
						</div>
						<div class="modal-footer">
							<button type="button" onclick="addCountry()"
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