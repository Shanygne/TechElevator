<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <c:import url="/WEB-INF/jsp/common/header.jsp" /> -->


<c:url var="formAction" value="alienTravelInput" />
<form method="GET" action="${formAction}">

<div class="formInputGroup">
	<h2>Alien Travel Calculator</h2>
	<label for="planetChoice">Choose a Planet:</label> 
		<select name="planetChoice"  id="planetChoice">
			<option value="Mercury">Mercury</option> <!-- value - what is returned when user clicks it - the words are what is displayed -->
			<option value="Venus">Venus</option>
			<option value="Earth">Earth</option>
			<option value="Mars">Mars</option>
			<option value="Jupiter">Jupiter</option>
			<option value="Saturn">Saturn</option>
			<option value="Uranus">Uranus</option>
			<option value="Neptune">Neptune</option>
		</select>
		
	<label for="travelModeChoice">Choose a Transport Mode:</label> 
		<select name="planetChoice"  id="planetChoice">
			<option value="Walking">Walking</option> <!-- value - what is returned when user clicks it - the words are what is displayed -->
			<option value="Car">Car</option>
			<option value="Bullet Train">Bullet Train</option>
			<option value="Boeing 747">Boeing 747</option>
			<option value="Concorde">Concorde</option>
		</select>

	<label for="age"> Enter Your Age:</label>
	<input type="text" name="age"  id="age"/>

<input class="formSubmitButton" type="submit" value="Calculate Travel Time" />

</div>

</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />