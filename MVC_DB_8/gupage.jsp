<%@ page import="models.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <title>GU Page</title>
 </head>
 <body>

 <h1>GU Page</h1>

 <% User user = (User)session.getAttribute("user"); %>

 <h3><%= user.getUserName() %></h3>

 <table>
	<tr>
		<td>
			<table border="1" width="100%">
				<tr>
					<td width="33%">Email</td>
					<td width="33%"><%= user.getEmail() %></td>
				</tr>
				<tr>
					<td>City</td>
					<td><%= user.getCity().getCity() %></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><%= user.getGender().getGender() %></td>
				</tr>
				<tr>
					<td>User Type</td>
					<td><%= user.getUserType().getUserType() %></td>
				</tr>	
			 </table>
			
		</td>
		<td>
			<td rowspan="4" width="33%">
				<iframe src="pic_upload.jsp" scrolling="no" frameborder="0" />
			</td>
		</td>
	</tr>
 </table>
 
 </body>
</html>
