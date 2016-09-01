<%@ page import="models.User" %>

<html>
	<head>
		<title>DB Another Page</title>
	</head>

	<body>

		<% String msg = (String)request.getAttribute("msg"); %>

		<% if(msg!=null){ %>
			<div style="border:2px solid red;background-color:yellow;color:red;font-size:22px;font-family:verdana;width:500px;margin:20px auto;text-align:center;padding:8px">			
				<%= msg %>
			</div>
		<% } %>
		
		<h1>Another Page</h1>
		

		<% User user = (User)session.getAttribute("user"); %>

		<% if(user.getUserType().equals(2)){ %>
			<a href="admin.do">Admin</a>
		<% }else{ %>
			<a href="general_user.do">GU</a>
		<% } %>

	</body>
</html>