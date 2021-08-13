<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>Role Permissions</b>
			</h3>
			<div class="box-tools pull-right">
			</div>
		</div>
		
		<div class="box-body">
			<div class="row">
				<div class="box-body">
					<div class="form-group col-sm-3">
						<label for="Country Code">Role Name :</label>
						<select  class="form-control">
							<option>---select---</option>
							<option>Role1</option>
							<option>Role2</option>
							<option>Role3</option>
						</select>
					</div>
					
					<div class="form-group col-sm-3">
						<label for="Country Code">Role Code :</label>
						<input type="text" disabled="disabled" class="form-control">
					</div>
					
					<div class="form-group col-sm-3">
						<label for="Country Code">Role Type :</label>
						<input type="text" disabled="disabled" class="form-control">
					</div>
					
					<div class="form-group col-sm-3">
						<label for="Country Code">Role Description :</label>
						<input type="text" disabled="disabled" class="form-control">
					</div>
			</div>

		</div>
		<div class="row">
			<div class="box-body">
			<div class="form-group col-sm-12">
				<table class="table table-bordered">
				  <thead style="background-color:#ddd;" class="thead-light">
				    <tr>
				      <th scope="col">Functions</th>
				      <th scope="col">Rights</th>
				      <th scope="col"><input type="checkbox"> Enable Functions</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<tr>
				      <td>Dashboard</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>Inquiry</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td colspan="3"><b>Manage Appointment</b></td>
				    </tr>
				    <tr>
				   	<tr>
				      <td>Add Appointment</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>View Appointment</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td colspan="3"><b>Test Master</b></td>
				    </tr>
				    <tr>
				   	<tr>
				      <td>Test Group</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>Test Name</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td colspan="3"><b>Role Master</b></td>
				    </tr>
				    <tr>
				   	<tr>
				      <td>Add Role</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>Role Permissions</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td colspan="3"><b>User Master</b></td>
				    </tr>
				    <tr>
				   	<tr>
				      <td>Add User</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>View Users</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td colspan="3"><b>B2B Registration</b></td>
				    </tr>
				    <tr>
				   	<tr>
				      <td>Lab Registration</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>Dr Registration</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>Franchise Registration</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				    <tr>
				      <td>View B2b Registrations</td>
				      <td><input type="checkbox"> MOD <br>
				      <input type="checkbox"> DEL <br>
				      <input type="checkbox"> VW<br>
				      <input type="checkbox"> ADD</td>
				      <td><i class="fa fa-flag btn btn-success"></i></td>
				    </tr>
				  </tbody>
				</table>
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

