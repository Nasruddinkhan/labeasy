
<section class="sidebar">
	<ul class="sidebar-menu" data-widget="tree">
		<li><a href="${pageContext.request.contextPath}/dasboard"> <i
				class="fa fa-question-circle"></i> <span>Dashboard</span>

		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/inquiry/show-inquiry-page">
				<i class="fa fa-question-circle"></i> <span>Inquiry</span>

		</a></li>
		<li class="treeview"><a href="#"> <i class="fa fa-calendar"></i>
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


		<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
				<span>Role Master</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/role-master/show-user-role"><i
						class="fa fa-plus text-yellow"></i> Add Role</a></li>
				<li><a
					href="${pageContext.request.contextPath}/role-master/show-user-role"><i
						class="fa fa-plus text-yellow"></i>Define Role Menus</a></li>
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

		<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
				<span>Master</span> <span class="pull-right-container"> <span
					class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/master/show-country-page"><i
						class="fa fa-user-plus text-white"></i> Country</a></li>

				<li><a
					href="${pageContext.request.contextPath}/master/show-state-page"><i
						class="fa fa-eye text-green"></i> State</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/show-city-page"><i
						class="fa fa-eye text-green"></i>City</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/show-pincode-page"><i
						class="fa fa-eye text-green"></i>PinCode</a></li>
			</ul></li>
	</ul>
</section>
<!-- /.sidebar -->