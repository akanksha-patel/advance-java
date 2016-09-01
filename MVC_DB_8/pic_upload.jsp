<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <title>Upload Pic</title>
 </head>
 <body>
  <img src="mypic.do" width="100" />
  <br />
  <form action="pic_upload.do" method="post" enctype="multipart/form-data">
	  <input type="file" name="pic" />
	  <br />
	  <input type="submit" value="Upload" />
  </form>
 </body>
</html>
