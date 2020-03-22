<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:set var="page to load " value="homepage" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Favorite Parks Page</title>
</head>
<body>
	<div id="main-content">
		<center>
			<div>
				<h2>Favorite Parks</h2>
				<div class="forecast">
					<c:forEach var="surveyList" items="${theSurveys}">
						<img src="img/parks/${surveyList.parkcode.toLowerCase()}.jpg"
							width=40% id="favimg">
						<br>
						<h3>
							<em>${surveyList.parkName} </em>has been surveyed <strong>${surveyList.surveyCount}</strong>
							time(s)!
						</h3>
						<br>

					</c:forEach>
				</div>
			</div>
		</center>
	</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</html>