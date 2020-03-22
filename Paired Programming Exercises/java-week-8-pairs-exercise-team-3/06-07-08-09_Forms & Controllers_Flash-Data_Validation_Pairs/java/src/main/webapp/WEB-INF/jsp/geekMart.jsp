<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quarkrs SSGeek Store - Earth Annex</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
<c:forEach var="product" items="${ products }">  <!-- each of the products from the ModelMap one at a time--> 
	<div>
		<a href="productDetail?id=${product.id}"><img src="img/${product.imageName}" width="200"/> </a>
		<small><b>${product.name}</b> - ${product.price}</small>	
	</div>
</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>