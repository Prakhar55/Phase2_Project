<%@page import="entity.Classes"%>
<%@page import="entity.Students"%>
<%@page import="entity.ClassCurriculum"%>
<%@page import="entity.TeacherSchedule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Learners Academy - Class Report</title>
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
					String id = (String)session.getAttribute("id");
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
     
     <h1 style="text-align:center">Class Report</h1>
	<div class="row">
		<div class="col-2 col-md-2">
			<div class="list-group">
		    	<a href="subjects" class="list-group-item list-group-item-action">Subjects</a>
		    	<a href="teachers" class="list-group-item list-group-item-action">Teachers</a>
		    	<a href="classes" class="list-group-item list-group-item-action">Classes</a>
		    	<a href="classcurr" class="list-group-item list-group-item-action">Class Curriculum</a>
		    	<a href="teachersschedule" class="list-group-item list-group-item-action">Teacher Schedule</a>
		    	<a href="students" class="list-group-item list-group-item-action">Students</a>
	    	</div>
	    </div>		    	
	    	<div class="col-7 col-sm-12 col-md-7"> 
				<form action="classreport" method="post">
				    Select Class:&nbsp;
				    <select name="classes">
				        <c:forEach items="${classes}" var="classes">
				            <option value="${classes.class_name}">${classes.class_name}</option>
				        </c:forEach>
				    </select>
				    <br/><br/>
				    <input type="submit" value="Submit" />
				</form>
					<c:set var = "error" value = "${requestScope.error}"/>
					<c:if test="${error != null}">
						<br/><br/>
						<h6 style="color:Red;">${error}</h6>
					</c:if>
				<div>
					<br/>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope ="col">Student ID</th>
									<th scope ="col">Student Name</th>
								</tr>
							</thead>
							<c:forEach var="students" items="${requestScope.students }">
								<tr>
									<td scope="row">${ students.id}</td>
									<td>${ students.stud_name}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
					<div>
					<br/>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope ="col">Subjects</th>
								</tr>
							</thead>
							<c:forEach var="classcurr" items="${requestScope.classcurr }">
								<tr>
									<td scope="row">${classcurr.subjects}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
					<div>
					<br/>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope ="col">Teacher</th>
									<th scope ="col">Subject</th>
								</tr>
							</thead>
							<c:forEach var="teachsched" items="${requestScope.teachsched }">
								<tr>
									<td scope="row">${teachsched.teach_name}</td>
									<td scope="row">${teachsched.sub_name}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
	    	</div>
	    </div>
</body>
</html>