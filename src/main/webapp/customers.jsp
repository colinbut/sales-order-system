<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>

<div id="content">
	<br />
	<button id="createCustomerButton" onclick="location.href='http://localhost:8080/SalesOrderSystem/customers/create'">
		Create Customer
	</button>
	<br />
	
	<datatables:table id="customerList" data="${customers}" 
										sortable="true"
										displayLength="20" 
										export="csv,pdf" 
										cssStripes="myOdd,myEven"
										row="customer">
		<datatables:column title="#"><c:out value="${customer_rowIndex}"></c:out></datatables:column>
		<datatables:column title="Name">${customer.customerName}</datatables:column>
		<datatables:column title="Date Of Birth">${customer.dateOfBirth}</datatables:column>
		<datatables:column title="Email Address">${customer.emailAddress}</datatables:column>
		<datatables:column title="Address">${customer.address}</datatables:column>
	</datatables:table>
	
	
</div>
<jsp:include page="footer.jsp"></jsp:include>