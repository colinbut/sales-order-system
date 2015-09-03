<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="taglibs.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
<div class="content">
	<br />
	<button id="createItemsButton" onclick="location.href='http://localhost:8080/SalesOrderSystem/items/create'">
		Create Items
	</button>
	<br />
	
	<datatables:table id="itemsList" data="${items}" 
										sortable="true"
										displayLength="20" 
										export="csv,pdf" 
										cssStripes="myOdd,myEven"
										row="item">
		<datatables:column title="Item id."><c:out value="${item_rowIndex}"></c:out></datatables:column>
		<datatables:column title="Item">${item.itemName}</datatables:column>
		<datatables:column title="Price">${item.itemPrice}</datatables:column>
	</datatables:table>
	
</div>

<jsp:include page="footer.jsp"></jsp:include>