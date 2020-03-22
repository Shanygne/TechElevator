<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<div id="main-content">
<h2>Login Page</h2><br>
<form:form action="${loginURL}" method="POST" modelAttribute="User">
<label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username"><br>
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password"><br>
        
        <div id="passwordHint">${passwordHint}</div>
    <button type="submit" class="btn btn-default">Login</button>
    <br>
    
<!--     <c:url var="passwordHint" value="/"/>
     <a href="${passwordHint}">Forgot password?</a> -->
    <br>
    <br>
    
    <fmt:parseDate value="${lastlogin}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both"/>
	<fmt:formatDate pattern="dd/MM/yyyy 'at' HH:mm:ss" value="${ parsedDateTime }" var="formattedDateTime"/>
    
    <small>Last Login: ${lastlogin}</small>
    </form:form>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />