<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<head>
<meta charset="UTF-8">
<title>National Park Weather Service</title>
</head>
<body>
	<div id="main-content">
		<form action="${submitAction}" method="GET">
			<br>
			<h2>List of National Parks</h2>
			<div class="flex-grid">
				<c:forEach items="${theParks}" var="Parks">
					<div class="col">
						<h3>
							<em>${Parks.parkName}</em>
						</h3>

						<c:url var="aPark" value="/detailPage">
							<c:param name="parkCode">${Parks.parkCode}</c:param>
						</c:url>
						<c:url value="img/parks/${Parks.parkCode.toLowerCase()}.jpg"
							var="parkImg" />
						<a class="park-image" href="${aPark}"> <img src="${parkImg}"
							id="parkimg" text align="left" width=12%><br>
						</a> <b>State:</b> ${Parks.state}
						<p>
							<small>${Parks.parkDescription}</small>
						</p>
						<br>
					</div>
					<hr>
				</c:forEach>
			</div>
		</form>
	</div>
	<c:import url="/WEB-INF/jsp/common/footer.jsp" />