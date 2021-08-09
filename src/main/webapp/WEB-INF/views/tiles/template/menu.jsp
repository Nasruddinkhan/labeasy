<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="sidebar">
	<ul class="sidebar-menu" data-widget="tree">
		<c:forEach var="menus" items="${sessionScope.menu}">
			<c:choose>
				<c:when test="${not menus.subMenu}">
					<li><a
						href="${pageContext.request.contextPath}/${menus.menuUrl}"> <i
							class="${menus.styleClass}"></i> <span>${menus.lableName}</span>
					</a></li>
				</c:when>

				<c:otherwise>
					<li class="treeview">
					 <a href="#"> <i
							class="${menus.styleClass}"></i> <span>${menus.lableName}</span>
							<span class="pull-right-container"> <span
								class="fa fa-angle-left pull-right"></span>
						</span>
					</a>
						<ul class="treeview-menu ">
							<c:forEach var="submenu" items="${menus.childmenu}">
								<li><a
									href="${pageContext.request.contextPath}/${submenu.menuUrl}">
										<i class="${submenu.styleClass}"></i> <span>${submenu.lableName}</span>
								</a></li>
							</c:forEach>

						</ul></li>
				</c:otherwise>
			</c:choose>

		</c:forEach>
		
	</ul>

</section>


<!-- /.sidebar -->