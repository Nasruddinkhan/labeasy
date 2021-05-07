
<section class="sidebar">
	<ul class="sidebar-menu" data-widget="tree">

		<li class="treeview"><a href="#"> <i class="fa fa-home"></i>
				<span>Dashboard</span>

		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/inquiry/show-inquiry-page">
				<i class="fa fa-question-circle"></i> <span>Inquiry</span>

		</a></li>
		<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
				<span>Manage Appointment</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/appointment/show-appointment-page"><i
						class="fa fa-street-view text-yellow"></i> Add Appointment</a></li>
				<li><a href="#"><i class="fa fa-gg-circle text-red"></i>
						View Appointments </a></li>

			</ul></li>
		<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
				<span>Master Test</span> <span class="pull-right-container">
					<span class="fa fa-angle-left pull-right"></span>
			</span>
		</a>
			<ul class="treeview-menu ">
				<li><a
					href="${pageContext.request.contextPath}/master-test/show-test-group "><i
						class="fa fa-street-view text-yellow"></i> Test Group</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master-test/show-test-name"><i
						class="fa fa-gg-circle text-red"></i> Test Name </a></li>

			</ul></li>
	</ul>
</section>
<!-- /.sidebar -->