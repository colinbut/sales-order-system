<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
	<h1>Create Order:</h1>
	<form:form method="POST" modelAttribute="createOrderForm" action="createOrder">
		<table>
			<tr>
				<td>Customer:</td>
				<td>
					<form:select path="customer">
						<form:option value="NONE" label="-- Select --" />
						<form:options items="${customersList}"/>
					</form:select>
				</td>
				<td>
					<form:errors path="customer" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Items:</td>
				<td>
					<form:select path="items" items="${ordersList}" multiple="true" />
				</td>
				<td>
					<form:errors path="customer" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit Order" /></td>
			</tr>
		</table>
	</form:form>
</div>
<jsp:include page="footer.jsp"></jsp:include>