<%@ page import="models.*" %>

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
 </body>

</html>
