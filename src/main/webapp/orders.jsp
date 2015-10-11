<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
<div class="content">
	<br />
		
	<datatables:table id="ordersList" data="${orders}" 
										sortable="true"
										displayLength="20" 
										export="csv,pdf" 
										cssStripes="myOdd,myEven"
										row="order">
		<datatables:column title="Order No."><c:out value="${order_rowIndex}"></c:out></datatables:column>
		<datatables:column title="Customer">${order.customer}</datatables:column>
		<datatables:column title="Address">${order.address}</datatables:column>
	</datatables:table>
	
</div>

<jsp:include page="footer.jsp"></jsp:include>