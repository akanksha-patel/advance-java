<%@ page import="java.util.ArrayList, models.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <script type="text/javascript" src="js/register.js"> </script>
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
	  <table id="tbl">	
		<tr>
			<td class="lbl">User Name</td>
			<td>:</td>
			<td>
				<input type="text" name="username" id="username" />
				&nbsp;&nbsp;&nbsp;
				<span class="msg" id="unm_msg">User Name is required</span>
			</td>
		</tr>
		<tr>
			<td class="lbl">Email</td>
			<td>:</td>
			<td>
				<input type="text" name="email" id="email" />
				&nbsp;&nbsp;&nbsp;
				<span class="msg" id="eml_msg">Email is required</span>
			</td>
		</tr>
		<tr>
			<td class="lbl">Password</td>
			<td>:</td>
			<td>
				<input type="password" name="password" id="password" maxlength="10" />
				&nbsp;&nbsp;&nbsp;
				<span class="msg" id="pwd_msg">Password is required</span>
			</td>
		</tr>
		<tr>
			<td class="lbl">Confirm Password</td>
			<td>:</td>
			<td>
				<input type="password" name="confirm_password" id="confirm_password" />
				&nbsp;&nbsp;&nbsp;
				<span class="msg" id="cnf_msg">Pass & ConfPass must match</span>
			</td>
		</tr>
		<tr>
			<td class="lbl">Gender</td>
			<td>:</td>
			<td>
				Male <input type="radio" name="gender" id="male" value="<%= Gender.MALE %>" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				Female <input type="radio" name="gender" id="female" value="<%= Gender.FEMALE %>" />
				&nbsp;&nbsp;&nbsp;
				<span class="msg" id="gnd_msg">Gender is required</span>
			</td>
		</tr>
		<tr>
			<td class="lbl">City</td>
			<td>:</td>
			<td>
				<select name="city" id="city">				
					<option value="0">Select</option>
					<% 
						for(int i=0;i<cities.size();i++){ 
							City city = (City)cities.get(i);
					%>
						<option value="<%= city.getCityId() %>"><%= city.getCity() %></option>
					<% } %>
				</select>
				&nbsp;&nbsp;&nbsp;
				<span class="msg" id="city_msg">City is required</span>
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
