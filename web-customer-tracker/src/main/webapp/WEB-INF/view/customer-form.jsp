<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>
<title>Save Customer</title>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</tbody>
			</table>

		</form:form>

		<p>
			<a href="${PageContext.request.contextPath}/web-customer-tracker/customer/list">Back to List</a>
		</p>
	</div>
</body>

</html>