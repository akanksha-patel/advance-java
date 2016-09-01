<%@ page import="models.City,java.util.*" %>

<html>
	<head>
		<title>DB GU Page</title>
	</head>

	<body>
		
		<h1>GU Page</h1>
		
		<%-- Case 2: 
			<% ArrayList<City> cities = City.collectCities(); %>
		--%>

		<% ArrayList<City> cities = (ArrayList)application.getAttribute("cities"); %>
		<select name="city">
			<% for(City city : cities){ %>
				<option value="<%= city.getCityId() %>">
					<%= city.getCity() %>
				</option>
			<% } %>
		</select>

	</body>
</html>