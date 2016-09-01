<%@ page import="java.util.ArrayList, models.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/register.css" />
  <title>Register</title>
 </head>
 <body>

	<% String msg = (String)request.getAttribute("msg"); %>

	<% if(msg!=null){ %>
		<div id="msg"><%= msg %></div>
	<% } %>

	<% ArrayList cities  = (ArrayList)application.getAttribute("cities"); %>	
	<form action="register.do">
	  <table border="1" width="70%">	
		<tr>
			<td>User Name</td>
			<td>:</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td>:</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td>:</td>
			<td><input type="password" name="password" maxlength="10" /></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td>:</td>
			<td><input type="password" name="confirm_password" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>:</td>
			<td>
				Male <input type="radio" name="gender" value="<%= Gender.MALE %>" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				Female <input type="radio" name="gender" value="<%= Gender.FEMALE %>" />
			</td>
		</tr>
		<tr>
			<td>City</td>
			<td>:</td>
			<td>
				<select name="city">				
					<option value="0">Select</option>
					<% 
						for(int i=0;i<cities.size();i++){ 
							City city = (City)cities.get(i);
					%>
						<option value="<%= city.getCityId() %>"><%= city.getCity() %></option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: center;">
				<input type="submit" value="Register" />
			</td>
		</tr>
	  </table>
	 </form>
 </body>
</html>
