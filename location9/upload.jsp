<%@ page import="models.*" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <title>Upload Page</title>
 </head>
 <body>

 <h1>Upload Page</h1>

 <% User user = (User)session.getAttribute("user"); %>

 <h3><%= user.getUserName() %></h3>


 <form action="upload.do" method="post" enctype="multipart/form-data">
	Email: <input type="text" name="email" /><br />
	Password: <input type="password" name="password" /><br />
	<input type="file" name="fup3" /><br />

	<input type="submit" value="Upload" />
 </form>
 </body>
</html>
