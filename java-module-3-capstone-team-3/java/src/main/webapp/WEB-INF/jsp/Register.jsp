<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body><div id="main-content">
<h2>Register Page</h2><br>

<c:url var="registerUrl" value="/register"/>
<form:form action="${registerUrl}" method="POST" modelAttribute="User">
    <div class="form-group">
        <label for="username">Username</label>
        <form:input class="form-control" path="username" placeholder="Username"/>
        <form:errors path="username" cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:password class="form-control" path="password" placeholder="Password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword">Password Hint</label>
        <form:password class="form-control" path="passwordHint" placeholder="Password Hint"/>
        <form:errors path="passwordHint" cssClass="error"/>
    </div>
    <div class="form-group">
    	<label for="email">Email</label>
		<form:input path="emailAddress" placeholder="Email" />
		<form:errors path="emailAddress" cssClass="error" />
    </div>
    <button type="submit" class="btn btn-default">Save User</button>
</form:form>
</div></body>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />