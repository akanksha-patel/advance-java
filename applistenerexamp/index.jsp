<%@ page import="models.City,java.util.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <title>Document</title>
 </head>
 <body>

	Show City List<br />


	<select name="city">
		<option value="0">Select</option>
		<% ArrayList cities = (ArrayList)application.getAttribute("cities"); %>

		<% 
			for(int i=0;i<cities.size();i++){ 
				City city = (City)cities.get(i);
		%>
				<option value="<%= city.getCityId() %>"><%= city.getCity()  %></option>		
		<% } %>
	</select>
  
 </body>
</html>
