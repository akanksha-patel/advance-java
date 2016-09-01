<html>
	<head>
		<title>DB Register</title>
	</head>

	<body>
		<% String msg = (String)request.getAttribute("msg"); %>

		<% if(msg!=null){ %>
			<div style="border:2px solid red;background-color:yellow;color:red;font-size:22px;font-family:verdana;width:500px;margin:20px auto;text-align:center;padding:8px">			
				<%= msg %>
			</div>
		<% } %>

		<form action="register.do" method="get">
			User Name: <input type="text" name="user_name" /><br />
			Email: <input type="text" name="email" /><br />
			Password: <input type="password" name="password" /><br />
			<input type="submit" value="Register" />			
		</form>

	</body>
</html>