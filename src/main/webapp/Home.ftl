<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description"
			content="控制台管理程序">
		<meta name="author" content="baijw">
		<!-- App title -->
		<title>XXX控制台程序</title>
		<!-- App CSS -->
		<link href="css/homestyle.css" rel="stylesheet" type="text/css" />
	</head>
	<body class="fixed-left widescreen">
	
	
		<!-- Begin page -->
		<div id="wrapper">
	
			<!-- Top Bar Start -->
			<div class="topbar">
	
				<!-- LOGO -->
				<div class="topbar-left">
					<a
						href="http://www.smates.cn"
						class="logo"> <i class="zmdi zmdi-group-work icon-c-logo"></i>
						<span>麦特智能</span></a>
				</div>
	
				<nav class="navbar navbar-custom">
					<ul class="nav navbar-nav">
						<li class="nav-item">
							<button
								class="button-menu-mobile open-left waves-light waves-effect">
								<i class="zmdi zmdi-menu"></i>
							</button>
						</li>
					</ul>
	
					<ul class="nav navbar-nav pull-right">
						<li class="nav-item dropdown notification-list"><a
							class="nav-link dropdown-toggle arrow-none waves-effect waves-light nav-user"
							data-toggle="dropdown"
							href="http://view.jqueryfuns.com/%E9%A2%84%E8%A7%88-/2016/7/8/322317b7d044fb1ebce220dc1e72481e/ui-cards.html#"
							role="button" aria-haspopup="false" aria-expanded="false"> <img
								src="./Uplon - Responsive Admin Dashboard Template_files/avatar-1.jpg"
								alt="user" class="img-circle">
						</a>
							<div
								class="dropdown-menu dropdown-menu-right dropdown-arrow profile-dropdown "
								aria-labelledby="Preview">
								<!-- item-->
								<div class="dropdown-item noti-title">
									<h5 class="text-overflow">
										<small>Welcome ! ${userName}</small>
									</h5>
								</div>
	
								<!-- item-->
								<a href="logout.do" class="dropdown-item notify-item">
									<i class="zmdi zmdi-power"></i> <span>Logout</span>
								</a>
							</div></li>
					</ul>
				</nav>
	
			</div>
			<!-- Top Bar End -->
	
			<!-- ========== Left Sidebar Start ========== -->
			<div class="left side-menu">
				<div class="slimScrollDiv"
					style="position: relative; overflow: hidden; width: auto; height: 503px;">
					<div class="sidebar-inner slimscrollleft"
						style="overflow: hidden; width: auto; height: 503px;">
						<!--- Sidemenu -->
						<div id="sidebar-menu">
							<ul>
								<#list menulist as item>
									<li class="has_sub">
										<a href="javascript:void(0);" class="waves-effect active"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></i> <span> ${item.menuName} </span></a>
										<ul class="list-unstyled">
											<#list item.submenus as record>
												<li>
													<a class="contentlink" href="javascript:void(0)" menuurl="${record.menuUrl}" >${record.menuName}</a>
												</li>
											</#list>
										</ul>
									</li>
								</#list>
							</ul>
							<div class="clearfix"></div>
						</div>
						<!-- Sidebar -->
						<div class="clearfix"></div>
					</div>
					<div class="slimScrollBar"
						style="width: 5px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 397.884px; visibility: visible; background: rgb(220, 220, 220);"></div>
					<div class="slimScrollRail"
						style="width: 5px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
				</div>
			</div>
			<!-- Left Sidebar End -->
	
			<!-- Start content-page -->
			<div class="content-page">
				<!-- Start content -->
				<div class="content">
					<div class="container">
						<iframe id="content_frame" frameborder="no" ></iframe>
					</div>
					<!-- container -->
				</div>
				<!-- content -->
			</div>
			<!-- End content-page -->
	
			<footer class="footer text-right"> 2016 © 安徽麦特智能技术有限公司. </footer>
		</div>
		<!-- END wrapper -->
	
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/waves.js"></script>
		<script src="js/jquery.app.js"></script>
		
		<script type="text/javascript">
			
			$("#content_frame,.container").height($(window).height()-$(".footer").height()-$(".navbar").height()-70).width("90%");
			$(".contentlink").click(function(){
				var menuUrl = this.getAttribute("menuurl");
				$("#content_frame").attr("src","${rc.getContextPath()}"+menuUrl);
				$(".contentlink").parent().attr("class","disactive");
				$(".contentlink").parent().parent().attr("style","");
				$(this).parent().attr("class","active");
				$(this).parent().parent().attr("style","display: block");
			});
		</script>
		
	</body>
</html>