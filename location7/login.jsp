<%@ page import="java.util.ArrayList, models.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/register.css" />
  <title>Login</title>
 </head>
 <body>
	
	
	<% String msg = (String)request.getAttribute("msg"); %>

	<% if(msg!=null){ %>
		<div id="msg"><%= msg %></div>
	<% } %>

	

	
	<form action="login.do">
	  <table border="1" width="70%">
		<tr>
			<td>Email</td>
			<td>:</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td>:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: center;">
				<input type="submit" value="Login" />
			</td>
		</tr>
	  </table>
	 </form>
 </body>
</html>
