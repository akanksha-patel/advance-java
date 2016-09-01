<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <title>Document</title>
 </head>
 <body>
	<%! int i = 0; %>

	<%= i++  %><br />
	<img height="100" src='mypic.do' />
	<br />
	<form action="pic_upload.do" enctype="multipart/form-data" method="post">
		<input type="file" name="fileupload" />
		<input type="submit" value="Upload" />
	</form>
 </body>
</html>
