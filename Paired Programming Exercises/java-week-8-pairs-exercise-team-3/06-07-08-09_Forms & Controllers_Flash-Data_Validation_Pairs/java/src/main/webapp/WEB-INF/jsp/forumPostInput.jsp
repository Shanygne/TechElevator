<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <c:import url="/WEB-INF/jsp/common/header.jsp" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Geek Post</title>
</head>
<body>

<c:url var="formAction" value="/forumPostInput"></c:url>
<form:form action="${formAction}" method="POST" modelAttribute="ForumPost">
<div class="formInputGroup">
<center>
		<div>
		<label for="name">Name</label>
		<form:input path="username" class="form-control"/>
		<form:errors path="username" cssClass="error" />
		</div>
		<div>
		<label for="subject">Subject</label>
		<form:input path="subject"/><br>
		<form:errors path="subject" cssClass="error" />
		</div>
		<div>
		<label for="message">Message</label>
		<form:input path="message" />
		<form:errors path="message" cssClass="error" />
		</div>
	<input class="formSubmitButton" type="submit" value="Submit"/>
	</center>
</div>
</form:form>


</body>











</html>

	<c:import url="/WEB-INF/jsp/common/footer.jsp" />