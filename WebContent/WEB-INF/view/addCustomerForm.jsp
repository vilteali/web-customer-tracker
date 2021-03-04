<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Add Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/addCustomerForm.css" />
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
			<h4>Save Customer</h4>
		</div>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id" />
				<div class="row mb-3">
					<label for="firstName" class="col-sm-2 col-form-label">First
						Name</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="firstName"
						placeholder="First Name" name="firstName"
						value="<c:out value="${customer.firstName}"/>" />
				</div>
			</div>
				<div class="row mb-3">
					<label for="lastName" class="col-sm-2 col-form-label">Last
						Name</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="lastName"
						placeholder="Last Name" name="lastName"
						value="<c:out value="${customer.lastName}"/>" />
				</div>
			</div>
				<div class="row mb-3">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" id="email"
						placeholder="Email" name="email"
						value="<c:out value="${customer.email}"/>" />
				</div>
			</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button class="btn btn-primary" type="submit">Save</button>
			</div>
		</form:form>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>
	</div>
</body>
</html>