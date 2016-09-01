<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <script src="js/ajax.js"> </script>
  <script src="js/index.js"> </script>  
  <title>Document</title>
 </head>
 <body>
 
  <input type="hidden" value="<%= request.getParameter("countryid") %>" id="cnparam" />

  Country: 
  <select name="country" id="country">
	<option value="0">Select</option>
	<option value="1">India</option>
	<option value="2">US</option>
  </select>

  <br /><br />

  State: 
  
  <select name="state" id="state">
	<option value='0'>Select</option>
  </select>

  <br /><br />

  City:
  <select name="city" id="city">
	<option value='0'>Select</option>
  </select>	

  
 </body>
</html>
