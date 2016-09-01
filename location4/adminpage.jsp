<%@ page import="models.*" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <title>Admin Page</title>
 </head>
 <body>

 <h1>Admin Page</h1>

 <% User user = (User)session.getAttribute("user"); %>

 <h3><%= user.getUserName() %></h3>
 </body>
</html>
