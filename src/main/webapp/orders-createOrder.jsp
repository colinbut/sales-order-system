<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="content">
	<h3>Create Order</h3>
	<form:form method="POST" modelAttribute="createOrderForm" action="createOrder">
		<table class="create-form-table">
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
					<form:select path="items" items="${itemsList}" multiple="true" />
				</td>
				<td>
					<form:errors path="items" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="reset" value="Reset" />
					<input type="submit" value="Submit Order" />
				</td>
			</tr>
		</table>
	</form:form>
</div>
<jsp:include page="footer.jsp"></jsp:include>