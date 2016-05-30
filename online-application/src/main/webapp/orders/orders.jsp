<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
<jsp:include page="/common/nav.jsp"></jsp:include>
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
		<datatables:column title="Address">${order.customer.address}</datatables:column>
	</datatables:table>
	
</div>

<jsp:include page="/common/footer.jsp"></jsp:include>
