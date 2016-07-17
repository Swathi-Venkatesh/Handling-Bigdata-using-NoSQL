<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src='js/jquery.js' type=text/javascript></script>
<script src='js/bootstrap.js' type=text/javascript></script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<%
		Long writemongo = (Long) request.getAttribute("writemongo");
		Long writemysql = (Long) request.getAttribute("writemysql");
		Long readmongo = (Long) request.getAttribute("readmongo");
		Long readmysql = (Long) request.getAttribute("readmysql");
		String msg = request.getParameter("msg");
	%>

	<%
		if (msg != null) {
	%>
	<h4><%=msg%></h4>
	<%
		}
	%>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Comparision of MySQL against NoSQL</h3>
		</div>
		<div class="panel-body">

			<div class='row'>
				<div class='col-md-3'>
					<div class="panel panel-primary">
						<div class="panel-heading">Insert Records</div>
						<div class="panel-body">
							<form action='compare' method=post>
								<label>Enter number of records</label> <input type=text
									class='form-control' name='n' placeholder='Number of Records' />
								<input type=hidden name='type' value='write' /> <br /> <input
									type=submit class='btn btn-primary' value='Compare' />
							</form>
						</div>
					</div>
				</div>

				<%
					if (writemongo != null) {
				%>
				<div class='col-md-3'>
					<div class="panel panel-primary">
						<div class="panel-heading">Write Operation</div>
						<div class="panel-body">

							Mongo DB :
							<%=writemongo%>
							milliseconds<br /> MySQL DB :
							<%=writemysql%>
							milliseconds<br />


						</div>
					</div>
				</div>
				<div class='col-md-3'>
					<div class="panel panel-primary">
						<div class="panel-heading">Read Operation</div>
						<div class="panel-body">
							Mongo DB :
							<%=readmysql%>
							milliseconds<br /> MySQL DB :
							<%=readmongo%>
							milliseconds<br />

						</div>
					</div>
				</div>

				<%
					}
				%>

				<div class='col-md-3'></div>



			</div>



		</div>
	</div>




</body>
</html>