<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<div>
	<h1>Customers</h1>
	<button id="createCustomerButton" onclick="location.href='http://localhost:8080/SalesOrderSystem/customers/create'">
		Create Customer
	</button>
	<table>
		<tr>
			<th>Customer Name</th>
			<th>Customer Date Of Birth</th>
			<th>Customer Email Address</th>
			<th>Customer Address</th>
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