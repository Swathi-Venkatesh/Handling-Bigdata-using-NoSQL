<!DOCTYPE html>
<html lang="en">

<head>

<title>SKIT - Prototype for NoSQL</title>

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>



<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" id="nav-padding" role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SKIT</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right" id="nav-left">
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Sri Krishna Institute of Technology (SKIT) </a></li>



				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="index.jsp">Home</a></li>
						<li><a class='active'  href="login.jsp">Login</a></li>
						<li><a href="create.jsp">Create Account</a></li>
						<li><a href="dev.jsp">Developers</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>

			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-offset-1 col-lg-11">
						<h1 class="page-header">Library Management Portal &nbsp;<span style='font-size: 24px;'>Powered by Mongo DB</span></h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-offset-1 col-lg-11">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="text-muted bootstrap-admin-box-title">Login Page</div>
							</div>
							<div class="bootstrap-admin-panel-content text-muted" style="padding: 60px 0;">
							
							  
							<div class='row'> 
								<div class='col-md-3'></div>
								
								<div class='col-md-6'>
								<%
									String msg = request.getParameter("msg");
										if (msg!=null) {
											%>
												<h4><%=msg %></h4>
											<%
										}
								%>
								
								<form action='login' method=post class='well'>
								
								<label>Enter your Email ID:</label>
								<input type=text name='email' placeholder='Email' class='form-control' />
								<br/>
								
								<label>Chose your Password:</label>
								<input type=password name='pwd' placeholder='Password' class='form-control' />
								<br/>
								
								<input type=submit class='btn btn-primary' value='Login' />
								
								
								</form>
								
								</div>
								
								<div class='col-md-3'></div>
							</div>
							
							
							
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
