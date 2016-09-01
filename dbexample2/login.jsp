<html>
	<head>
		<title>DB Login</title>
	</head>

	<body>
		<% String msg = (String)request.getAttribute("msg"); %>

		<% if(msg!=null){ %>
			<div style="border:2px solid red;background-color:yellow;color:red;font-size:20px;font-family:verdana;width:300px;margin:20px auto;text-align:center;padding:4px">
				<%= msg %>
			</div>
		<% } %>

		<form action="login.do" method="get">
			Email: <input type="text" name="email" /><br />
			Password: <input type="password" name="password" /><br />
			<input type="submit" value="Login" />			
		</form>

	</body>
</html>