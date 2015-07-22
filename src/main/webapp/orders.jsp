<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>

<div>
	<h1>Orders</h1>
	<button id="createOrderButton" onclick="location.href='http://localhost:8080/SalesOrderSystem/orders/create'">
		Create Order
	</button>
	<table>
		<tr>
			<th>Order No.</th>
			<th>Customer</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.orderNo}</td>
				<td>${order.customer}</td>
				<td>${order.address}</td>
			</tr>
		</c:forEach>
	</table>
	
</div>

<jsp:include page="footer.jsp"></jsp:include>