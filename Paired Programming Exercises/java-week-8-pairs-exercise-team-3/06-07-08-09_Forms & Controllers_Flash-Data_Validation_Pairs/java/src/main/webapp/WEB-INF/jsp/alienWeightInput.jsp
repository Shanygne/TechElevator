<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" /> 
<center>
<h2>Alien Weight Calculator</h2>
<c:url var="formAction" value="/AlienWeightResult" />
<form method="GET" action="${formAction}">
<div class="formInputGroup">
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
<div>	
	<label for="earthWeight"> Enter Your Earth Weight:</label>
	<input type="text" name="earthWeight"  id="earthWeight"/>
</div>		
	<input class="formSubmitButton" type="submit" value="Calculate Weight" />
</div>

</form>
</center>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />