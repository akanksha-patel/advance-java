<%@ page import="models.User" %>

<html>
	<head>
		<title>DB Login Profile Page</title>
	</head>

	<body>

		<h1>Profile Page</h1>

		<% User user = (User)session.getAttribute("user"); %>

		Welcome <%= user.getUserName() %>

	</body>
</html>