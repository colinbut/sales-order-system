<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
	<br />
	<button id="createCustomerButton" onclick="location.href='http://localhost:8080/SalesOrderSystem/customers/create'">
		Create Customer
	</button>
	<br />
	<table>
		<tr>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Email Address</th>
			<th>Address</th>
		</tr>
	
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td><c:out value="${customer.customerName}"></c:out></td>
				<td><c:out value="${customer.dateOfBirth}"></c:out></td>
				<td><c:out value="${customer.emailAddress}"></c:out></td>
				<td><c:out value="${customer.address}"></c:out></td>
				
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>