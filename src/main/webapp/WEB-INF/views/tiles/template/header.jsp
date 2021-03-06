<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><strong>Lab</strong>Easy</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><strong>Lab</strong>Easy</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
       <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> -->
              Admin User <span class="hidden-xs fa fa-user-md">    </span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Admin 
                  <small>Member since Nov. 2015</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
             <!--    <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div> -->
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="${pageContext.request.contextPath}/user-profile/view-profile-details"" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                <form action='<spring:url value="/logout"/>' method="post">
                <!--   <a href="#" class="btn btn-default btn-flat">Sign out</a> -->
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  <input value="Sign out" class="btn btn-default btn-flat" type="submit">
                  </form>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>

    </nav>