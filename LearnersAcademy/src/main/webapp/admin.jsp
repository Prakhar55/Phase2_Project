<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Learners Academy - Admin</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
            <!--nav bar-->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="index.jsp">
                	<img src="images/LearnersAcademy_logo.jpg" width="200" height="200" alt="">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    				<span class="navbar-toggler-icon"></span>
  				</button>
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			    	<%
					String id = (String) session.getAttribute("id");
					if (id != null) {
					%>
                	<li class="nav-item active">
			        	<a class="nav-link" href="logout.jsp">Logout</a>
			      	</li>
			      <%
					}
					%>
				 </ul>
			   </div> 
            </nav>
     </div>
	
	<h1 style="text-align:center">Welcome ADMIN</h1>
	<div class="col-2 col-md-2">
		<div class="list-group">
	    	<a href="subjects" class="list-group-item list-group-item-action">Subjects</a>
	    	<a href="classcurr" class="list-group-item list-group-item-action">Class Curriculum</a>
	    	<a href="teachers" class="list-group-item list-group-item-action">Teachers</a>
	    	<a href="classes" class="list-group-item list-group-item-action">Classes</a>
	    	<a href="notice_board.htm" class="list-group-item list-group-item-action">Students</a>
	    	<a href="all_teachers" class="list-group-item list-group-item-action ">Class Report</a>
    	</div>
    </div>
	<%-- <%
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
	%> --%>
</body>
</html>