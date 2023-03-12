<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Learners Academy</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="index.jsp">
                	<img src="images/LearnersAcademy_logo.jpg" width="200" height="200" alt="">
                </a>
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			    	<%
					String id = (String) session.getAttribute("id");
					if (id == null) {
					%>
			      <li class="nav-item active">
			        <a class="nav-link" href="login.jsp">Login (Admin)</a>
			      </li>
			      	<%
					}
					if (id != null) {
					%>
				  <li class="nav-item active">
			        <a class="nav-link" href="admin.jsp">Admin Page</a>
			      </li>
				  <li class="nav-item active">
			        <a class="nav-link" href="logout.jsp">Logout</a>
			      </li>
			      <%
					}
					%>
			    </ul>
			  </div>
            </nav>
            <div class="jumbotron jumbotron-fluid">
                <div class="container">             
                    <h1 style="text-align:center" class="mr-sm-2"  class="text-primary">Welcome to Learner's Academy</h1>
                    <img src="images/School_Building.jpg" width="1050" height="400" alt="">
                 </div>
            </div>
        </div>
    </body>
</html>
