<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Create Customer:</h1>
	
	<form:form method="POST" modelAttribute="createCustomerForm" action="createCustomer">
		<table>
			<tr>
				<td>Firstname:</td>
				<td><form:input id="firstName" path="firstName" /></td>
			</tr>
			<tr>
				<td>Lastname:</td>
				<td><form:input id="lastName" path="lastName" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><form:input id="dob" path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Email address:</td>
				<td><form:input id="email" path="emailAddress" /></td>
			</tr>
			<tr>
				<td>House/Flat No:</td>
				<td><form:input id="houseFlatNo" path="houseFlatNo" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input id="street" path="street" /></td>
			</tr>
			<tr>
				<td>Postcode:</td>
				<td><form:input id="postcode" path="postcode" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input id="city" path="city" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input id="country" path="country" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>				
			</tr>
		</table>
	</form:form>
<jsp:include page="footer.jsp"></jsp:include>