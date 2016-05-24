<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="content">
	<h3>Create Item</h3>
	<form:form method="POST" modelAttribute="createItemForm" action="createItem">
		<table class="create-form-table">
			<tr>
				<td>Item Name:</td>
				<td>
					<form:input path="itemName"/>
				</td>
				<td>
					<form:errors path="itemName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Item Price (&pound;):</td>
				<td>
					<form:input path="itemPrice"/>
				</td>
				<td>
					<form:errors path="itemPrice" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="reset" value="Reset" />
					<input type="submit" value="Submit New Item" />
				</td>
			</tr>
		</table>
	</form:form>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
