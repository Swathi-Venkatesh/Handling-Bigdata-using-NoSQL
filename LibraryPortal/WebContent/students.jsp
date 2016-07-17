<!DOCTYPE html>
<%@page import="com.skit.pojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.skit.pojo.User"%>
<html lang="en">

<head>

<title>SKIT - Prototype for NoSQL</title>

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<%
	User user = (User) session.getAttribute("user");
	if (user != null) {
%>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" id="nav-padding"
			role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SKIT</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right" id="nav-left">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> Sri Krishna Institute of Technology (SKIT) </a></li>



				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="home.jsp">Home</a></li>
						<li><a href="books">Books</a></li>
						<li><a class='active' href="students">Students</a></li>
						<li><a href="transaction.jsp">Transaction</a></li>
						<li><a href="logout">Logout</a></li>
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
						<h1 class="page-header">
							Library Management Portal &nbsp;<span style='font-size: 24px;'>Powered
								by Mongo DB</span>
						</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-offset-1 col-lg-11">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="text-muted bootstrap-admin-box-title">Home
									Page</div>
								<div class="text-muted bootstrap-admin-box-title">
									Welcome
									<%=user.getEmail()%>, <a href='logout'>Logout</a>
								</div>
							</div>
							<div class="bootstrap-admin-panel-content text-muted"
								style="padding: 60px 0; text-align: center">
								<%
									String msg = request.getParameter("msg");
										if (msg != null) {
								%>
								<div class='row'>
									<div class='col-md-6'>
										<div class="alert alert-warning alert-dismissible"
											role="alert">
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<strong><%=msg%></strong>
										</div>

									</div>
									<div class='col-md-3'></div>
								</div>
								<%
									}
								%>
								<div class='row'>
									<div class='col-md-1'></div>
									<div class='col-md-4'> 
										<form action='writeStudent' method=post class='well'>

											<label>Student USN</label> <input type=text
												class='form-control' name='usn' /> <br /> <label>Student
												Name</label> <input type=text class='form-control' name='name' /> <br />
											<input type=submit value='ADD STUDENT'
												class='btn btn-primary' style='width: 100%;' /> <br />
										</form>

									</div>

									<div class='col-md-6'>
										<%
											List<Student> students = (List<Student>) request.getAttribute("students");
												if (students != null && students.size() > 0) {
										%>

										<%
											for (Student s : students) {
										%>
										<div class='col-md-6'>
											<div class='panel panel-warning'>
												<div class="panel-heading">


													<span class='glyphicon glyphicon-user'
														style='font-size: 50px;'></span>


													<h3 class="panel-title text-left"></h3>


												</div>
												<div class="panel-body">
													<%=s.getName()%><br /> (<%=s.getUsn()%>)
												</div>
												<div class="panel-footer">
													<a href='removeStudent?usn=<%=s.getUsn()%>'>Remove</a>
												</div>

											</div>
										</div>

										<%
											}
										%>

										<%
											}
										%>
									</div>
									<div class='col-md-1'></div>
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
<%
	} else {
		response.sendRedirect("login.jsp?msg=Please login to continue");
	}
%>
</html>
