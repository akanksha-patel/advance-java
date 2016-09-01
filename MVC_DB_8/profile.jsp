<%@ page import="models.*,java.util.ArrayList" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/register.css" />
  <script src="js/ajax.js" type="text/javascript"> </script>
  <script src="js/profile.js" type="text/javascript"> </script>
  <title>Profile</title>
 </head>


 <body>
	<% 	
		User user = (User)session.getAttribute("user"); 
		String msg = (String)request.getAttribute("msg");
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


	<br />
	
	<% ArrayList states = (ArrayList)application.getAttribute("states"); %>
	<select name="state" id="state">
		<option value="0">State</option>
		<% 
			for(int i=0;i<states.size();i++){ 
				State state = (State)states.get(i);
		%>
			<option value="<%= state.getStateId() %>"><%= state.getState() %></option>
		<% } %>
	</select>


	<select name="city" id="city">
		<option value="0">City</option>
	</select>
 </body>

</html>
