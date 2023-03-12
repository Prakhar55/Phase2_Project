<%@page import="entity.ClassCurriculum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Learners Academy - Teacher's Schedule</title>
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
     
     <h1 style="text-align:center">Teacher's Schedule</h1>
	<div class="row">
		<div class="col-2 col-md-2">
			<div class="list-group">
		    	<a href="subjects" class="list-group-item list-group-item-action">Subjects</a>
		    	<a href="teachers" class="list-group-item list-group-item-action">Teachers</a>
		    	<a href="classes" class="list-group-item list-group-item-action">Classes</a>
		    	<a href="classcurr" class="list-group-item list-group-item-action">Class Curriculum</a>
		    	<a href="students" class="list-group-item list-group-item-action">Students</a>
		    	<a href="classreport		" class="list-group-item list-group-item-action ">Class Report</a>
	    	</div>
	    </div>	
	    	<div class="col-7 col-sm-12 col-md-7"> 
				<div class="container">
					<div>
						<div class="wrapper fadeInDown">
							<div id="formContent">
								<form action="teachersschedule" method="POST">
									<input type="submit" class="fadeIn fourth" value="Set Teacher Schedule" />
								</form>
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
									<th scope ="col">Teacher Name</th>
									<th scope ="col">Class Name</th>
									<th scope ="col">Subject Name</th>
									<th scope ="col">Delete Row</th>
								</tr>
							</thead>
							<c:forEach var="teachsched" items="${requestScope.teachsched }">
								<tr>
									<td scope="row">${teachsched.teach_name}</td>
									<td>${teachsched.class_name}</td>
									<td>${teachsched.sub_name}</td>
									<td><a href="delete?teachschedule=${teachsched}">Delete</a> </td>
								</tr>
							</c:forEach>
						</table>
					</div>
	    		</div>
	    </div>
</body>
</html>