<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Our Shopping Cart</title>
</head>
<body>
<c:set var="grandTotal" value="0"/>
<div>
<section>
<table>
	<tr>
		<th></th>
		<th>Name</th>
		<th>Price</th>
		<th>Qty.</th>
		<th>Total</th>
	</tr>
	<c:forEach var="cartItem" items="${cart}">
		<c:set var="cartPrice" value="${cartItem.item.price.hashCode()/100 * cartItem.quantity}"/>
		<c:set var="grandTotal" value="${grandTotal + cartPrice}"/>
			<tr>
				<td><img src="img/${cartItem.item.imageName}" width=200></td>
				<td>${cartItem.item.name}</td>
				<td>${cartItem.item.price}</td>
				<td>${cartItem.quantity}</td>
				<td>$${cartPrice}</td>
			</tr>
	</c:forEach>
</table>
<strong>Grand Total:</strong><tr> $${Math.round(grandTotal)}</tr><br>
<a href="${checkOut}">Check out</a>
</div>
</body>
</html>