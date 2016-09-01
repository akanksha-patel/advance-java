<%@ page import="models.*,java.util.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/profile.css" />
  <script type="text/javascript" src="js/ajax.js"> </script>
  <script type="text/javascript" src="js/profile.js"> </script>
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
	
	  <table border="1" width="70%">	
		<tr>
			<td>User Name</td>
			<td>:</td>
			<td>
				<span id="unm_box"><%= user.getUserName() %></span>
				&nbsp;&nbsp;&nbsp;
				<span class="lnk" id="unm_edit">Edit</span>
				&nbsp;&nbsp;&nbsp;
				<span class="cncl" id="unm_cancel">Cancel</span>
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>:</td>
			<td>
				<%= user.getEmail() %>
				&nbsp;&nbsp;&nbsp;
				<span class="lnk" id="emledit">Edit</span>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>:</td>
			<td><a >Change Password</a></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>:</td>
			<td>
				<%= user.getGender().getGenderId()==1?"Female":"Male" %>
			</td>
		</tr>
		<tr>
			<td>City</td>
			<td>:</td>
			<td>
				<% 
					for(int i=0;i<cities.size();i++){ 
						City city = (City)cities.get(i);
				%>
					<%= user.getCity().getCityId()==city.getCityId()?city.getCity():"" %>
				<% } %>
			</td>
		</tr>
	  </table>
 </body>

</html>
