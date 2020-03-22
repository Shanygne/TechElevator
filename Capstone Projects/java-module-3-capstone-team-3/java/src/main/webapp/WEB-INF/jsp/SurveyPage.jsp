<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<head>
<meta charset="UTF-8">
<title>National Park Survey Page</title>
</head>
<body>
	<div id="main-content">
		<h2>Survey Page</h2>
		<h3>
			<em>Please fill out our survey below based on your favorite
				park:</em>
		</h3>
		<c:url var="surveyUrl" value="/surveyPage" />
		<form:form action="${surveyUrl}" method="POST" modelAttribute="Survey">
			<label for="parkcode">Park:</label>
			
			<form:select path="parkName">
				<form:option value="NONE" label="Park:"/>
				<c:forEach items="${theNames}" var="parkName">
					<option>${parkName.parkName}</option>
				
				</c:forEach>
			</form:select>

			<div>
				<label for="email">Email</label>
				<form:input path="email" value="Input a Valid Email" />
				<form:errors path="email" cssClass="error" />
			</div>


			<div>
				<label for="state">State:</label> <select name="state" id="state">
					<option value="NONE">Select a State</option>
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
				</select>
			</div>

			<div>
				<label for="activityLevel">Activity Level:</label> <select
					name="activityLevel" id="activityLevel">
					<option value="NONE">Select an Activity Level</option>
					<option value="inactive">Inactive</option>
					<option value="sedentary">Sedentary</option>
					<option value="active">Active</option>
					<option value="extremelyactive">Extremely Active</option>
				</select>
			</div>



			<input type="submit" value="Submit" class="btn btn-default">
		</form:form>
	</div>
	<c:import url="/WEB-INF/jsp/common/footer.jsp" />