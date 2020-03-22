<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
<!-- <c:import url="/WEB-INF/jsp/common/header.jsp" /> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail Page</title>
</head>
<body>
<div>
	<img src="img/${product.imageName}" width="400"/>
	<h1>${product.name}</h1>
	${product.price}<br>
	<br>
	${product.description}
</div>
<br>
<div>
	<form method="POST" action="shoppingCart" />
	<input type="hidden" name="id" value="${product.id}">
	<label for="quantity" >How many would you like?</label>
	<input name="quantity" type="text" />
	<input type="submit" value="throw in the cart"/>
	</form>
</div>
</body>
</html>