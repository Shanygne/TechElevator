<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <c:import url="/WEB-INF/jsp/common/header.jsp" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Solar System Forum</title>
</head>
<body><center>
<table class="table">

<c:forEach items="${postKey}" var="aPost">

<tr>
<th>${aPost.subject}</th>
</tr>


<tr>
  	<td><c:out value="by ${aPost.username} on ${aPost.datePosted}"/>  </td>
</tr>

<tr>
  	<td><c:out value="${aPost.message}"/>  </td>
</tr>
</c:forEach>
</table>

 



</center>
</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />