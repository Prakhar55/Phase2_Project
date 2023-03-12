<%@page import="entity.Subjects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Learners Academy - Teachers</title>
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
     
     <h1 style="text-align:center">Teacher's Details</h1>
	<div class="row">
		<div class="col-2 col-md-2">
			<div class="list-group">
				<a href="subjects" class="list-group-item list-group-item-action">Subjects</a>
		    	<a href="classes" class="list-group-item list-group-item-action">Classes</a>
		    	<a href="classcurr" class="list-group-item list-group-item-action">Class Curriculum</a>
		    	<a href="teachersschedule" class="list-group-item list-group-item-action">Teacher Schedule</a>
		    	<a href="students" class="list-group-item list-group-item-action">Students</a>
		    	<a href="classreport" class="list-group-item list-group-item-action ">Class Report</a>
	    	</div>
	    </div>	
	    	
	    	<div class="col-7 col-sm-12 col-md-7"> 
				<div class="container">
					<div>
						<div class="wrapper fadeInDown">
							<div id="formContent">
								<form action="add" method="POST">
									<h5 class='sign'>Add New Teacher</h5>
									<input type="text" id="teach_name" class="fadeIn second" name="teach_name" placeholder="Teacher's Name"/>
									<input type="submit" class="fadeIn fourth" value="Add" />
								</form>
								<br/><br/>
								<c:set var = "error" value = "${requestScope.error}"/>
								<c:if test="${error != null}">
								<br/><br/>
								<h6 style="text-align:center;color:Red;">${error}</h6>
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<div>
					<br/>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope ="col">Teacher's ID</th>
									<th scope ="col">Teacher's Name</th>
									<th scope ="col">Delete Row</th>
								</tr>
							</thead>
							<c:forEach var="teachers" items="${requestScope.teachers }">
								<tr>
									<td scope="row">${ teachers.id}</td>
									<td>${ teachers.teach_name}</td>
									<td><a href="delete?teach_name=${ teachers.teach_name}">Delete</a> </td>
								</tr>
							</c:forEach>
						</table>
					</div>
	    		</div>
	    </div>
</body>
</html>