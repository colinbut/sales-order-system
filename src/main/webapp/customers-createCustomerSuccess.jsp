<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Customer Confirmation</title>
</head>
<body>

	<h1>Create Customer Confirmation:</h1>
	
	<table>
		<!-- Customer -->
		<tr>
			<td>
				<label>Firstname:</label>
			</td>
			<td>
				${submittedCustomerForm.firstName}
			</td>
		</tr>
		<tr>
			<td>
				<label>Lastname:</label>
			</td>
			<td>
				${submittedCustomerForm.lastName}
			</td>
		</tr>
		<tr>
			<td>
				<label>Date of Birth:</label>
			</td>
			<td>
				${submittedCustomerForm.dateOfBirth}
			</td>
		</tr>
		<tr>
			<td>
				<label>Email:</label>
			</td>
			<td>
				${submittedCustomerForm.email}
			</td>
		</tr>
		
	</table>

</body>
</html>