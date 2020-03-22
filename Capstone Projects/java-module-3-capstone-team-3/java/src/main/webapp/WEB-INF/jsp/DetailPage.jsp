<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="page to load " value="homepage" />

<head>
<meta charset="UTF-8">
<title>National Park Detail Page</title>
</head>
<body>
	<div id="main-content">
		<div id="parkInfo">
			<c:set var="Parks" value="${aPark}" />
			<h2>${Parks.parkName}</h2>
			<br> <img src="img/parks/${Parks.parkCode.toLowerCase()}.jpg"
				id="detailimg" text align="left"> <em>"${Parks.inpirationalQuote}"</em>
			- <b>${Parks.quoteResource}</b>
			<p>
				<b>Park Description:</b> ${Parks.parkDescription}
			</p>
			<b>State:</b> ${Parks.state}<br> <b>Year Founded:</b>
			${Parks.yearFounded}<br> <b>Acreage:</b> ${Parks.acreage}<br>
			<b>Elevation in Feet:</b> ${Parks.elevationInFeet}<br> <b>Miles
				of Trail:</b> ${Parks.milesOfTrail}<br> <b>Number of Campsites:</b>
			${Parks.numberOfCampsites}<br> <b>Park Climate:</b>
			${Parks.climate}<br> <b>Annual Visitor Count:</b>
			${Parks.annualVisitorCount}<br> <b>Number of Animal Species:</b>
			${Parks.numberOfAnimals}<br> <b>Park Entry Fee: $</b>${Parks.entryFee}<br>
		</div>
		<br> <br> <br>
		<hr>
		<h2>5-Day Weather Forecast</h2>
		<center>
			Please select a measure of temperature:
			<div id="tempChoice">
				<c:url var="temperatureLink" value="/detailPage">
					<c:param name="temperature" value="celsius" />
					<c:param name="parkCode" value="${Parks.parkCode}" />
				</c:url>
				<a href="${temperatureLink}">°C</a> |
				<c:url var="temperatureLink" value="/detailPage">
					<c:param name="temperature" value="fahrenheit" />
					<c:param name="parkCode" value="${Parks.parkCode}" />
				</c:url>
				<a href="${temperatureLink}">°F</a>
			</div>
		</center>

		<div class="forecast">
			<c:forEach var="dailyWeather" items="${weatherList}">
				<c:choose>
					<c:when test="${dailyWeather.day==1}">
						<div>
							<c:choose>
								<c:when test="${dailyWeather.forecast=='partly cloudy'}">
									<img src="img/weather/partlyCloudy.png" id="forecastimg" />
								</c:when>
								<c:otherwise>
									<img src="img/weather/${dailyWeather.forecast}.png"
										id="forecastimg" />
								</c:otherwise>
							</c:choose>
							<br> <b>High:</b> ${dailyWeather.hiTemp}°<br> <b>Low:</b>
							${dailyWeather.loTemp}°<br> 
							
							<b>Forecast:</b> ${dailyWeather.forecast}<br>
							<p>Today's Weather Advisory:</p> ${dailyWeather.getAdvisory()}<br> 
						</div>
					</c:when>
					<c:otherwise>
						<div>
							<c:choose>
								<c:when test="${dailyWeather.forecast=='partly cloudy'}">
									<img src="img/weather/partlyCloudy.png" id="forecastimg" />
								</c:when>
								<c:otherwise>
									<img src="img/weather/${dailyWeather.forecast}.png"
										id="forecastimg" />
								</c:otherwise>
							</c:choose>
							<b>High:</b> ${dailyWeather.hiTemp}°<br> <b>Low:</b>
							${dailyWeather.loTemp}°<br> <b>Forecast:</b>
							${dailyWeather.forecast}<br>
							
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<c:import url="/WEB-INF/jsp/common/footer.jsp" />