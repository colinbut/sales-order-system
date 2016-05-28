<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
<jsp:include page="/common/nav.jsp"></jsp:include>
<div class="content">
	<br />
	<h1>${customer.firstName} ${customer.lastName}</h1>
	
	<!-- Customer Information -->
	
	<div>
		<table>

			<tr>
				<td>
					<label>Firstname:</label>
				</td>
				<td>
					${customer.firstName}
				</td>
			</tr>
			<tr>
				<td>
					<label>Lastname:</label>
				</td>
				<td>
					${customer.lastName}
				</td>
			</tr>
			<tr>
				<td>
					<label>Date of Birth:</label>
				</td>
				<td>
					${customer.dateOfBirth}
				</td>
			</tr>
			<tr>
				<td>
					<label>Email:</label>
				</td>
				<td>
					${customer.email}
				</td>
			</tr>
			
		</table>
	</div>
	
	<!-- Orders -->
	<div>
	
		<button id="createOrderButton" onclick="location.href='${base}orders/create?customerId=${customer.customerId}'">
			Create Order
		</button>
		<br />
		<datatables:table id="ordersList" data="${customer.orders}" 
										sortable="true"
										displayLength="20" 
										export="csv,pdf" 
										cssStripes="myOdd,myEven"
										row="order">
			<datatables:column title="Order No."><c:out value="${order_rowIndex}"></c:out></datatables:column>
		</datatables:table>
	</div>
	
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
