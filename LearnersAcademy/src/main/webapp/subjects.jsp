<%@page import="entity.Subjects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Learners Academy - Class Curriculum</title>
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
     
     <h1 style="text-align:center">All Subjects</h1>
	<div class="row">
		<div class="col-2 col-md-2">
			<div class="list-group">
		    	<a href="classcurr" class="list-group-item list-group-item-action">Class Curriculum</a>
		    	<a href="teachers" class="list-group-item list-group-item-action">Teachers</a>
		    	<a href="classes" class="list-group-item list-group-item-action">Classes</a>
		    	<a href="notice_board.htm" class="list-group-item list-group-item-action">Students</a>
		    	<a href="all_teachers" class="list-group-item list-group-item-action ">Class Report</a>
	    	</div>
	    </div>	
	    	
	    	<div class="col-7 col-sm-12 col-md-7"> 
				<div class="container">
					<div>
						<div class="wrapper fadeInDown">
							<div id="formContent">
								<form action="add" method="POST">
									<h5 class='sign'>Add New Subject</h5>
									<input type="text" id="sub_name" class="fadeIn second" name="sub_name" placeholder="Subject Name"/> 
									<input type="submit" class="fadeIn fourth" value="Add" />
								</form>
								<%
									String error = request.getParameter("error");
								if(error !=  null){
								%>
								<div class="error"><%= error %></div>
								<%} %>
							</div>
						</div>
					</div>
				</div>
				<div>
					<br/>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope ="col">Subject Name</th>
									<th scope ="col">Delete Row</th>
								</tr>
							</thead>
							<c:forEach var="subjects" items="${requestScope.subjects }">
								<tr>
									<td scope="row">${ subjects.sub_name}</td>
									<td><a href="delete?sub_name=${ subjects.sub_name}">Delete</a> </td>
								</tr>
							</c:forEach>
						</table>
					</div>
	    		</div>
	    </div>
</body>
</html>