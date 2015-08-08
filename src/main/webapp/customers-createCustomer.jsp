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
				<td><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Lastname:</td>
				<td><form:input id="lastName" path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><form:input id="dob" path="dateOfBirth" /></td>
				<td><form:errors path="dateOfBirth" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Email address:</td>
				<td><form:input id="email" path="emailAddress" /></td>
				<td><form:errors path="emailAddress" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>House/Flat No:</td>
				<td><form:input id="houseFlatNo" path="houseFlatNo" /></td>
				<td><form:errors path="houseFlatNo" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input id="street" path="street" /></td>
				<td><form:errors path="street" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Postcode:</td>
				<td><form:input id="postcode" path="postcode" /></td>
				<td><form:errors path="postcode" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input id="city" path="city" /></td>
				<td><form:errors path="city" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input id="country" path="country" /></td>
				<td><form:errors path="country" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><h3>Payment Details</h3></td>
				<td></td>
			</tr>		
			<tr>
				<td>Card No.:</td>
				<td><form:input id="cardNo" path="cardNo" /></td>
				<td><form:errors path="cardNo" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Card Exp Date:</td>
				<td><form:input id="expDate" path="expDate" /></td>
				<td><form:errors path="expDate" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Customer Reference:</td>
				<td><form:input id="customerReference" path="customerReference" /></td>
				<td><form:errors path="customerReference" cssClass="error"></form:errors></td>
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