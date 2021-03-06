<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>

<head>
<title>Palash's Company page</title>
</head>

<body>
	<h2>This is the home page - XYZA</h2>
	<hr>
	<p>Welcome to the company home page</p>

	<hr>

	<!-- Display username and role -->
	User:
	<security:authentication property="principal.username" />
	<br>
	<br> Role(s):
	<security:authentication property="principal.authorities" />

	<!-- Add a link to point to /leaders.. this is for the managers-->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a> (Only for manager peeps)
		</p>
	</security:authorize>
	<hr>

	<!-- Add a link to point to /systems.. this is for the admins -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				meeting</a> (Only for admin peeps)
		</p>
	</security:authorize>

	<hr>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>


</body>

</html>