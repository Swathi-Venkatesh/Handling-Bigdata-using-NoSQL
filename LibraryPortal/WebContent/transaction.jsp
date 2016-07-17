<!DOCTYPE html>
<%@page import="com.skit.pojo.StudentBooks"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.skit.pojo.Student"%>
<%@page import="com.skit.pojo.Book"%>
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
						<li><a href="students">Students</a></li>
						<li><a class='active' href="transaction.jsp">Transaction</a></li>
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
								style="padding: 60px 0;">

								<%
									String msg = request.getParameter("msg");
										if (msg != null) {
								%>
								<div class='row'>
									<div class='col-md-1'></div>
									<div class='col-md-10'><%=msg%></div>
									<div class='col-md-1'></div>
								</div>
								<%
									}
								%>

								<div class='row'>
									<div class='col-md-1'></div>
									<div class='col-md-10'>
										<form action='studentusn' method=post class='well'>
											<label>Student USN</label> <input type=text name='usn'
												class='form-control' placeholder='Enter the student USN' />
											<input type=submit value='GO' class='btn btn-primary' />
										</form>
									</div>

									<div class='col-md-1'></div>
								</div>



								<div class='row'>
									<div class='col-md-1'></div>
									<div class='col-md-10'>
										<div class='row'>
											<%
												Student st = (Student) request.getAttribute("student");
													List<Book> borrowed = (List<Book>) request.getAttribute("borrowed");
													List<StudentBooks> borrowedBooks = (List<StudentBooks>) request.getAttribute("borrowedBooks");
													int i = 0;
													if (st != null) {
											%>

											<div class='row'>
												<div class='col-md-1'></div>
												<div class='col-md-1'>
													<span class='glyphicon glyphicon-user'
														style='font-size: 50px;'></span>
												</div>
												<div class='col-md-8'><%=st.getName()%>
													<br />(<%=st.getUsn()%>)
												</div>
												<div class='col-md-1'></div>
											</div>
											<div class='row'>
												<hr />
											</div>
											<%
												SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
														for (Book b : borrowed) {
															StudentBooks borrowedBook = borrowedBooks.get(i);
											%>

											<div class='row'>
												<div class='col-md-1'></div>
												<div class='col-md-1'></div>
												<div class='col-md-1'>
													<span class='glyphicon glyphicon-book'
														style='font-size: 50px;'></span>
												</div>
												<div class='col-md-5'><%=b.getBook_title()%>
													<br />(<%=b.getBook_author()%>) <br />Date of borrow:
													<%=borrowedBook.getDate_of_borrow()%>
													<br> Date of return:
													<%=borrowedBook.getDate_of_return()%>
												</div>
												<div class='col-md-2'>
													<form action="returnbook" class='form-inline' method=post>
														<input type=hidden name='usn' value='<%=st.getUsn()%>' />
														<input type=hidden name='isbn' value='<%=b.getBook_id()%>' />
														<input type=submit class='btn btn-success btn-sm'
															style='width: 100px;' value='RETURN' />
													</form>
													<br />
<!-- 													<form action="renewbook" class='form-inline' method=post> -->

<%-- 														<input type=hidden name='usn' value='<%=st.getUsn()%>' /> --%>
<%-- 														<input type=hidden name='usn' value='<%=b.getBook_id()%>' /> --%>
<!-- 														<input type=hidden name='borrowdate' -->
<%-- 															value='<%=sdf.format(borrowedBook.getDate_of_borrow())%>' /> --%>
<!-- 														<input type=hidden name='returndate' -->
<%-- 															value='<%=sdf.format(borrowedBook.getDate_of_return())%>' /> --%>
<!-- 														<input type=submit class='btn btn-warning btn-sm' -->
<!-- 															style='width: 100px;' value='RENEW' /> -->
<!-- 													</form> -->
												</div>
												<div class='col-md-1'></div>
											</div>
											<div class='row'>
												<hr />
											</div>


											<%
												i++;
														}
											%>

											<div class='row'>
												<div class='col-md-1'></div>
												<div class='col-md-10'>
													<form class="form-inline" action='borrow' method=post>
														<div class="form-group">
															<div class="input-group">
																<div class="input-group-addon">ISBN</div>
																<input type=hidden name='usn' value='<%=st.getUsn()%>' />
																<input type="text" class="form-control"
																	id="exampleInputAmount" name='isbn'
																	placeholder="Book ISBN"> <input type=date
																	name='return' />
															</div>
														</div>
														<button type="submit" class="btn btn-primary">BORROW</button>
													</form>

												</div>
												<div class='col-md-1'></div>
											</div>




											<%
												}
											%>
										</div>
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
