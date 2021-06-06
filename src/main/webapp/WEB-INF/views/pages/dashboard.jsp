<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-primary ">
		<div class="box-header with-border">
			<h3 class="box-title">Dashboard</h3>

			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-aqua">
						<div class="inner">
							<h3>150</h3>

							<p>New Appointments</p>
						</div>
						<div class="icon">
							<i class="fa fa-shopping-cart"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-green">
						<div class="inner">
							<h3>53</h3>

							<p>New Enquiries</p>
						</div>
						<div class="icon">
							<i class="ion ion-stats-bars"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-yellow">
						<div class="inner">
							<h3>10</h3>

							<p>User Registred</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-add"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-red">
						<div class="inner">
							<h3>65</h3>

							<p>Test Master</p>
						</div>
						<div class="icon">
							<i class="ion ion-pie-graph"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>


				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-aqua">
						<div class="inner">
							<h3>150</h3>

							<p>Appointments Tracker</p>
						</div>
						<div class="icon">
							<i class="fa fa-shopping-cart"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-green">
						<div class="inner">
							<h3>53</h3>

							<p>Audit History</p>
						</div>
						<div class="icon">
							<i class="ion ion-stats-bars"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-yellow">
						<div class="inner">
							<h3>10</h3>

							<p>Daily Reports</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-add"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-red">
						<div class="inner">
							<h3>65</h3>

							<p>Inventories</p>
						</div>
						<div class="icon">
							<i class="ion ion-pie-graph"></i>
						</div>
						<a href="#" class="small-box-footer"> More info <i
							class="fa fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>

			</div>




		</div>
	</div>
	<div class="box box-primary ">
		<div class="box-header with-border">
			<h3 class="box-title">${message}</h3>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-sm-4" id="username-page">
					<form id="usernameForm" name="usernameForm">
						<div class="form-group">
							<label>Enter your name & join the conversion</label> <input
								type="text" id="name" placeholder="Username" autocomplete="off"
								class="form-control" />
						</div>
						<div class="form-group">
							<button type="submit"
								class="btn btn-primary btn-small accent username-submit">Start
								chatting</button>
						</div>
					</form>
				</div>
				<div class="col-sm-4">
					<div id="chat-page" class="hidden">
						<div class="chat-container">
							<div class="connecting">Connecting...</div>
							<div id="messageArea"></div>
							<form id="messageForm" name="messageForm" nameForm="messageForm">
								<div class="form-group">
									<input type="text" id="message" placeholder="Type a message..."
										autocomplete="off" class="form-control" />
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-small primary">Send</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

