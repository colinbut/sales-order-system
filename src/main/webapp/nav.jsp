<%@ include file="taglibs.jsp" %>
<div id="navigation">
	<c:set var="base" value="${pageContext.request.contextPath}/" />
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${base}customers">Customers</a></li>
		<li><a href="${base}orders">Orders</a></li>
		<li><a href="${base}items">Items</a></li>
	</ul>
</div>