<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="content">
	
	<form:form method="POST" modelAttribute="createCustomerForm" action="createCustomer">
		<table class="create-form-table">
			<tr>
				<td>
					<h3>Create Customer</h3>
				</td>
				<td></td>
			</tr>
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
				<td><h3>Payment Details</h3></td>
				<td></td>
			</tr>		
			<tr>
				<td>Card No.:</td>
				<td><form:input id="cardNo" path="cardNo" /></td>
			</tr>
			<tr>
				<td>Card Exp Date:</td>
				<td><form:input id="expDate" path="expDate" /></td>
			</tr>
			<tr>
				<td>Customer Reference:</td>
				<td><form:input id="customerReference" path="customerReference" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="reset" value="Reset">
					<input type="submit" value="Create">
				</td>				
			</tr>
		</table>
	</form:form>
</div>
<jsp:include page="footer.jsp"></jsp:include>