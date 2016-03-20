<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
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
				<td><form:input id="email" path="email" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>House/Flat No:</td>
				<td><form:input id="houseFlatNo" path="address.houseFlatNo" /></td>
				<td><form:errors path="address.houseFlatNo" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input id="street" path="address.street" /></td>
				<td><form:errors path="address.street" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Postcode:</td>
				<td><form:input id="postcode" path="address.postCode" /></td>
				<td><form:errors path="address.postCode" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input id="city" path="address.city" /></td>
				<td><form:errors path="address.city" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input id="country" path="address.country" /></td>
				<td><form:errors path="address.country" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><h3>Payment Details</h3></td>
				<td></td>
			</tr>		
			<tr>
				<td>Card No.:</td>
				<td><form:input id="cardNo" path="customerPaymentDetail.cardNo" /></td>
				<td><form:errors path="customerPaymentDetail.cardNo" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Card Exp Date:</td>
				<td><form:input id="expDate" path="customerPaymentDetail.cardExpiryDate" /></td>
				<td><form:errors path="customerPaymentDetail.cardExpiryDate" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Customer Reference:</td>
				<td><form:input id="customerReference" path="customerPaymentDetail.customerReference" /></td>
				<td><form:errors path="customerPaymentDetail.customerReference" cssClass="error"></form:errors></td>
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
<jsp:include page="/common/footer.jsp"></jsp:include>
