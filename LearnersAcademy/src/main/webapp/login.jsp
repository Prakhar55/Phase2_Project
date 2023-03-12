<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Learners Academy - Login</title>
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
	<div class="container">
		<div>
			<div class="wrapper fadeInDown">
				<div id="formContent">
					<div class="fadeIn first">
						<h2 style="text-align:center" class='sign'>Sign In</h2>
					</div>
					<form style="text-align:center" action="login" method="POST">
						<div class="form-group">
							<label >Username</label>
							<input type="text" id="login" class="fadeIn second" name="username" placeholder="Enter username" /> 
						</div>
						<div class="form-group">
							<label >Password</label>
							<input type="password" id="password" class="fadeIn third" name="password" placeholder="Enter password" /> 
						</div>
						<div class="form-group">
						<input type="submit" class="fadeIn fourth" value="Log In" />
						</div>
					</form>
					<c:set var = "error" value = "${requestScope.error}"/>
					<c:if test="${error != null}">
						<br/><br/>
						<h6 style="text-align:center;color:Red;">${error}</h6>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>