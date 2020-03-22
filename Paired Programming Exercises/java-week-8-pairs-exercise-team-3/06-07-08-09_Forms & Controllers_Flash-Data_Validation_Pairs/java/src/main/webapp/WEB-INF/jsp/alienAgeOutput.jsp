<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle" value="Mortgage Calculator" />
</c:import>


  <div class="white">
        <h2>${param.planetChoice}</h2>
        
        <img src="/img/${param.planetChoice}.jpg" />
        
	<!-- 	 <c:url var="mercuryImgSrc" value="/img/mercury.jpg" />
		<img src="${mercuryImgSrc}" alt="Mercury">    -->
		
		
        <p>If you are ${param.earthAge} years old on planet Earth, then you are ${convert.alienAge} ${param.planetChoice} years old.</p>
      
   </div>


















<c:import url="/WEB-INF/jsp/common/footer.jsp" />