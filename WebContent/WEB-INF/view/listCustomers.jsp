<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/listCustomers.css"/>
	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" 
	 	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<form:form action="searchCustomer" method="GET">
			<div class="input-group d-flex justify-content-center align-items-center">
				<div class="form-outline">
					<input type="text" class="form-control"
						placeholder="Search Customer" name=searchCustomer /> <label
						class="form-label" for="search-focus"></label>
				</div>
				<button type="submit" id="search-button" class="btn btn-primary">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form:form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<c:url var="update" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}"/>
						</c:url>
						<c:url var="delete" value="/customer/showFormForDelete">
							<c:param name="customerId" value="${customer.id}"/>
						</c:url>	
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<a href="${update}">Update</a>
							&nbsp;|
							<a href="${delete}"
								onclick="if (!(confirm('Are you sure you want yo delete this customer?')))
								return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-grip gap-2 d-md-flex justify-content-md-end">
			<input class="btn btn-primary" type="submit" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;">	
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/listCustomers.js"></script>
</body>
</html>