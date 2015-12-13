<%@ include file="meta.jsp" %>
<link rel="stylesheet" href="<c:url value="/css/sos.css" />" >
<link rel="stylesheet" href="<c:url value="/css/logout.css" />" >
<title>Sales Order System</title>
</head>
<body>
	<div id="header">
		<h1>Sales Order System</h1>

		<c:url value="/j_spring_security_logout" var="logoutUrl" />

		<form id="logoutForm" action="${logoutUrl}" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

        <a class="logoutButton" href="javascript:formSubmit()">Logout</a>
	</div>

	<script>
	    function formSubmit() {
	        document.getElementById("logoutForm").submit();
	    }
	</script>
	

