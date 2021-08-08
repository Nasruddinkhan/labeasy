
<section class="sidebar">
	<ul class="sidebar-menu" data-widget="tree">
		<li><a href="${pageContext.request.contextPath}/dasboard"> <i
				class="fa fa-home"></i> <span>Dashboard</span>

		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/inquiry/show-inquiry-page">
				<i class="fa fa-question-circle"></i> <span>Inquiry</span>

		</a></li>
		<li class="treeview"><a href="#"> <i class="fa fa-address-book-o"></i>
				<span>Manage Appointment</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/appointment/show-appointment-page"><i
						class="fa fa-plus text-yellow"></i> Add Appointment</a></li>
				<li><a
					href="${pageContext.request.contextPath}/appointment/view-appointment-page"><i
						class="fa fa-eye text-green"></i> View Appointments </a></li>

			</ul></li>
		<li class="treeview " id="treeview-menu-plus"><a href="#"> <i
				class="fa fa-tasks"></i> <span>Test Master</span> <span
				class="pull-right-container"> <span
					class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu " id="treeview-menu-plus-ul">
				<li><a
					href="${pageContext.request.contextPath}/master-test/show-test-group "><i
						class="fa fa-plus text-yellow"></i> Test Group</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master-test/show-test-name"><i
						class="fa fa-plus text-red"></i> Test Name </a></li>

			</ul></li>


		<li class="treeview"><a href="#"> <i class="fa fa-user-secret"></i>
				<span>Role Master</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/role-master/show-user-role"><i
						class="fa fa-plus text-yellow"></i> Add Role</a></li>
				<li><a
					href="${pageContext.request.contextPath}/role-master/show-role-permissions"><i
						class="fa fa-plus text-yellow"></i>Role Permissions</a></li>
			</ul></li>
		<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
				<span>User Master</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/user-master/show-add-user-page"><i
						class="fa fa-user-plus text-white"></i> Add New User</a></li>

				<li><a
					href="${pageContext.request.contextPath}/user-master/view-users"><i
						class="fa fa-eye text-green"></i> View Users</a></li>

			</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-users"></i>
				<span>B2B Registration</span> <span class="pull-right-container"> <span
					class="fa fa-angle-left pull-right"></span>
			</span>
			</a>
			<ul class="treeview-menu ">
				<li><a
			href="${pageContext.request.contextPath}/b2b/show-lab-registration"><i
				class="fa fa-plus text-yellow"></i> Lab Registration</a></li>
				<li><a
			href="${pageContext.request.contextPath}/b2b/show-dr-registration"><i
				class="fa fa-user-md  text-red"></i> Dr Registration</a></li>
				<li><a
			href="${pageContext.request.contextPath}/b2b/show-franchise-registration"><i
				class="fa fa-user-o text-blue"></i> Franchise Registration</a></li>
				<li><a
			href="${pageContext.request.contextPath}/b2b/view-b2b-registration"><i
				class="fa fa-eye  text-green"></i> View B2B Registrations</a></li>
	
		</ul>
			
			<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
				<span>My Profile</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/user-profile/view-profile-details"><i
						class="fa fa-eye text-green"></i> View Profile</a></li>

				<li><a
					href="${pageContext.request.contextPath}/user-profile/show-change-password"><i
						class="fa fa-key text-red"></i> Change Password</a></li>

			</ul></li>
		    
		    <li class="treeview"><a href="#"> <i class="fa fa-balance-scale"></i>
				<span>Admin Reports</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="#"><i
						class="fa fa-question-circle text-green"></i> Inquiries</a></li>

				<li><a
					href="#"><i
						class="fa fa-address-book-o text-yellow"></i> Appointments</a></li>
				<li><a
					href="#"><i
						class="fa fa-key text-red"></i> Audit</a></li>

			</ul></li>

		 <li class="treeview"><a href="#"> <i class="fa fa-user"></i>
				<span>Master</span> <span class="pull-right-container"> <span
					class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/master/show-country-page"><i
						class="fa fa-map-signs text-blue"></i> Country</a></li>

				<li><a
					href="${pageContext.request.contextPath}/master/show-state-page"><i
						class="fa fa-map-pin text-green"></i> State</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/show-city-page"><i
						class="fa fa-location-arrow text-yellow"></i>City</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/show-pincode-page"><i
						class="fa fa-map-marker text-red"></i>PinCode</a></li>
			</ul></li>
			
</section>


<!-- /.sidebar -->