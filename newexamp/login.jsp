<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/common.css" />
  <title>Document</title>
 </head>
 <body>
	<%@ include file="header.jsp" %>
	<form action="login.do">
		
		Email: <input type="text" name="eml" /> <br /><br />
		Password: <input type="text" name="pwd" /> <br /><br />
		
		<input type="submit" value="Login" /> <br /><br />
	</form>
 </body>
</html>
