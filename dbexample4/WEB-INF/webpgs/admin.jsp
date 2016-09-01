<%@ page import="models.City,java.util.*" %>

<html>
	<head>
		<title>DB Admin Page</title>
	</head>

	<body>
		
		<h1>Admin Page</h1>

		<% ArrayList<City> cities = (ArrayList)application.getAttribute("cities"); %>
		<select name="city">
			<% for(City city : cities){ %>
				<option value="<%= city.getCityId() %>"><%= city.getCity() %>++</option>
			<% } %>
		</select>
		

	</body>
</html>