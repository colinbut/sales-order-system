<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<h1>Create Order:</h1>
	<form:form method="POST" modelAttribute="createOrderForm" action="createOrder">
		<table>
			<tr>
				<td>Customer:</td>
			</tr>
			<tr>
				<td>Items:</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit Order" /></td>
			</tr>
		</table>
	</form:form>
<jsp:include page="footer.jsp"></jsp:include>