<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<button id="createCustomerButton" onclick="location.href='http://localhost:8080/SalesOrderSystem/customers/create'">
		Create Customer
	</button>
	<table>
		<tr>
			<th>Customer Firstname</th>
			<th>Customer Lastname</th>
			<th>Customer DOB</th>
			<th>Customer Email Address</th>
			<th>House No</th>
			<th>Street</th>
			<th>Postcode</th>
			<th>City</th>
			<th>Country</th>
		</tr>
	
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td><c:out value="${customer.firstName}"></c:out></td>
				<td><c:out value="${customer.lastName}"></c:out></td>
				<td><c:out value="${customer.dateOfBirth}"></c:out></td>
				<td><c:out value="${customer.email}"></c:out></td>
				<td><c:out value="${customer.address.houseFlatNo}"></c:out></td>
				<td><c:out value="${customer.address.street}"></c:out></td>
				<td><c:out value="${customer.address.postcode}"></c:out></td>
				<td><c:out value="${customer.address.city}"></c:out></td>
				<td><c:out value="${customer.address.country}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</div>