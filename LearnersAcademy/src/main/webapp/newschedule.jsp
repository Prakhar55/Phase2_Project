<%@page import="entity.Teachers"%>
<%@page import="entity.ClassCurriculum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Learners Academy - New Schedule</title>
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
     <h1 style="text-align:center">Set New Schedule</h1>
     		<c:set var = "error" value = "${requestScope.error}"/>
			<c:if test="${error != null}">
			<br/><br/>
			<h6 style="text-align:center;color:Red;">${error}</h6>
			</c:if>
	<div class="row">
		<div class="col-2 col-md-2">
			<div class="list-group">		    	
		    	<a href="subjects" class="list-group-item list-group-item-action">Subjects</a>
		    	<a href="classcurr" class="list-group-item list-group-item-action">Class Curriculum</a>
		    	<a href="teachers" class="list-group-item list-group-item-action">Teachers</a>
		    	<a href="classes" class="list-group-item list-group-item-action">Classes</a>
		    	<a href="students" class="list-group-item list-group-item-action">Students</a>
		    	<a href="classreport" class="list-group-item list-group-item-action ">Class Report</a>
	    	</div>
	    </div>	
	    	<div class="col-7 col-sm-12 col-md-7"> 
				<div>
					<br/>
						<div id="formContent">
								<form action="add" method="POST">								
									<table class="table table-striped">
											<tr>
						                        <th></th>
						                        <th>Teachers</th>
						                    </tr>
										<c:forEach var="teachers" items="${teachers}">
						                    <tr>
						                        <td><input type="radio" name="schedule_teach" value="${teachers.teach_name}"> </td>
						                        <td>${teachers.teach_name}</td>
						                    </tr>
			                			</c:forEach>
			                										
											<tr>
						                        <th></th>
						                        <th>Classes</th>
						                        <th>Subject</th>
						                    </tr>
										<c:forEach var="classcurr" items="${classcurr}">
						                    <tr>
						                        <c:set var="subjects">${classcurr.subjects} </c:set>
													<c:forTokens items="${subjects}" delims="," var="sub_name">
													    <tr>
													    <c:set var="class_curr">${classcurr.class_name},${sub_name} </c:set>
													    <td><input type="radio" name="schedule_classcurr" value="${class_curr}"> </td>
						                       			<td>${classcurr.class_name}</td>
													    <td>${sub_name}</td>
													    </tr>
													</c:forTokens>
						                    </tr>
			                			</c:forEach>
									</table>
									<input type="submit" class="fadeIn fourth" value="Add" />						
								</form>
						</div>
					</div>
	    		</div>
	    </div>
</body>
</html>