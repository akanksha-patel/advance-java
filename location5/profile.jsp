<%@ page import="models.*,java.util.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/register.css" />
  <title>Profile</title>
 </head>


 <body>
	<% 	
		User user = (User)session.getAttribute("user"); 
		String msg = (String)request.getAttribute("msg");
		ArrayList cities = (ArrayList)application.getAttribute("cities");
	%>

	<% if(msg!=null){ %>
		<div id="msg"><%= msg %></div>
	<% } %>
	
	<h1>Profile Page</h1>
	<h2>Welcome: <span><%= user.getUserName() %></span></h2> 
	

	<% if(user.getUserType().getUserTypeId()==1){ %>
		<a href="adminpage.do">Admin</a>
	<% }else{ %>
		<a href="gupage.do">General User</a>
	<% } %>
	
	<br /><br />
	<form action="update.do">
	  <table border="1" width="70%">	
		<tr>
			<td>User Name</td>
			<td>:</td>
			<td><input type="text" name="username" value="<%= user.getUserName() %>"  /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td>:</td>
			<td><input type="text" name="email" value="<%= user.getEmail() %>" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td>:</td>
			<td><input type="password" name="password" maxlength="10" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>:</td>
			<td>
				Male <input type="radio" name="gender" value="<%= Gender.MALE %>" <%= user.getGender().getGenderId()==1?"":"checked='checked'" %>  />
				&nbsp;&nbsp;&nbsp;&nbsp;
				Female <input type="radio" name="gender" value="<%= Gender.FEMALE %>" <%= user.getGender().getGenderId()==1?"checked='checked'":"" %> />
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
						<option value="<%= city.getCityId() %>" <%= user.getCity().getCityId()==city.getCityId()?"selected='selected'":"" %>><%= city.getCity() %></option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: center;">
				<input type="submit" value="Update" />
			</td>
		</tr>
	  </table>
	 </form>
 </body>

</html>
