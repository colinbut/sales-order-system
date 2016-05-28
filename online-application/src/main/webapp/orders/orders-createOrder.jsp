<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="content">
	<h3>Create Order</h3>
	<form:form method="POST" modelAttribute="createOrderForm" action="createOrder">
		<table class="create-form-table">
			
			<tr>
				<td>
					Customer:
				</td>
				<td>
					${createOrderForm.customer.firstName} ${createOrderForm.customer.lastName}
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
<jsp:include page="/common/footer.jsp"></jsp:include>
