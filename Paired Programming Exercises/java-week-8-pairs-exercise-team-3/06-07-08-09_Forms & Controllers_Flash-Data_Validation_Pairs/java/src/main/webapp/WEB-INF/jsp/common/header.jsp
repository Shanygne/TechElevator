<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Solar System Geek</title>
    <c:url value="/css/solarsystemgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/ssg_logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Solar System Geek logo" />
        </a>
        <h1>The Solar System</h1>
        <p>The Solar System formed 4.6 billion years ago from the gravitational collapse of a giant interstellar molecular cloud. The vast majority of the system's mass is in the Sun, with most of the remaining mass contained in Jupiter. The four smaller inner planets, Mercury, Venus, Earth and Mars, are terrestrial planets, being primarily composed of rock and metal. The four outer planets are giant planets, being substantially more massive than the terrestrials. The two largest, Jupiter and Saturn, are gas giants, being composed mainly of hydrogen and helium; the two outermost planets, Uranus and Neptune, are ice giants, being composed largely of substances with relatively high melting points compared with hydrogen and helium, called ices, such as water, ammonia and methane. All planets have almost circular orbits that lie within a nearly flat disc called the ecliptic. </p>
    </header>
    <nav>
        <h2>Explore The Solar System</h2>
        <p> Use these state of the art web applications to learn more about the solar system! </p>
        <ul>
            <li><a href="alienAgeInput">Alien Age</a></li>
            <li><a href="alienWeightInput">Alien Weight</a></li>
            <li><a href="alienTravelInput">Drive Time</a></li> 
            <li><a href="forumPostInput">Space Forum</a></li> 
            <li><a href="store">Space Store</a></li>               
        </ul>
    </nav>