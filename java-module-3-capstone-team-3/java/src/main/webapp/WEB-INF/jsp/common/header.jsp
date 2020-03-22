<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<title>National Park Weather Service</title>

	<c:url value="/css/site.css" var="cssURL" />
	<link rel="stylesheet" type="text/css" href="${cssURL}">

	<body class="mainContainer">
	<header>
	<c:url value="/" var="homePageHref" />
	<c:url value="img/logo.png" var="logoImg"/>
	<a href="${homePageHref}">
	<img src="${logoImg}" id="logo" />
	</a>

	<h1 id="headerTitle">National Park Weather Service</h1>
	</header>
	
	 <nav>
        <ul>
            <li><a href="${homePageHref}">Home</a></li>
            <li><a href="surveyPage">Survey Page</a></li>
            <li><a href="favoriteParks">Favorite Parks</a></li> 
            
            <c:if test="${empty appCurrentUser}">
                        <c:url var="loginUrl" value="/login"/>
                        <li><a href="${loginUrl}">Login</a></li>
                        <c:url var="registerUrl" value="/register"/>
                        <li><a href="${registerUrl}">Register</a></li>
                    </c:if>
                    <c:if test="${not empty appCurrentUser}">
                        <li><a href="/"><c:out value="${appCurrentUser.username}" /></a></li><br>
                        <c:url var="logoffUrl" value="/logoff"/>
                        <li>
                            <form action="${logoffUrl}" method="POST" class="navbar-form">
                                <button type="submit" class="btn btn-primary">Log Off</button>
                            </form>
                        </li>
                    </c:if>            
        </ul>
    </nav>
	

