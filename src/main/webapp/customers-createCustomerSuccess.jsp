<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>

	<h1>Create Customer Confirmation:</h1>
	
	<table>
		<!-- Customer -->
		<tr>
			<td>
				<label>Firstname:</label>
			</td>
			<td>
				${submittedCustomerForm.firstName}
			</td>
		</tr>
		<tr>
			<td>
				<label>Lastname:</label>
			</td>
			<td>
				${submittedCustomerForm.lastName}
			</td>
		</tr>
		<tr>
			<td>
				<label>Date of Birth:</label>
			</td>
			<td>
				${submittedCustomerForm.dateOfBirth}
			</td>
		</tr>
		<tr>
			<td>
				<label>Email:</label>
			</td>
			<td>
				${submittedCustomerForm.emailAddress}
			</td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">OK</button></td>
		</tr>
		
	</table>
<jsp:include page="footer.jsp"></jsp:include>