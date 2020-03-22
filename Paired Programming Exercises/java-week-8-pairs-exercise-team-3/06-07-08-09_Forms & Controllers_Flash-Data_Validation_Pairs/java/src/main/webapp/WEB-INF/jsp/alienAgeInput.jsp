<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <c:import url="/WEB-INF/jsp/common/header.jsp" /> -->


<c:url var="formAction" value="alienAgeOutput" />
<form method="GET" action="${formAction}">

<div class="formInputGroup">
	<h2>Alien Age Calculator</h2>
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
		
	<label for="earthAge"> Enter Your Earth Age:</label>
	<input type="text" name="earthAge"  id="earthAge"/>
	
	<input class="formSubmitButton" type="submit" value="Calculate Age" />
</div>

</form>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />