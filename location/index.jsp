<%@ page import="java.util.*,models.*" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
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
  <% ArrayList states = (ArrayList)request.getAttribute("states"); %>
  <select name="state">
	<% 
		if(states!=null){ 
			for(int i=0;i<states.size();i++){
				State state = (State)states.get(i);
	%>
		<option value="<%= state.getStateId() %>"><%= state.getStateName() %></option>
	<% }} %>	
  </select>

  <br /><br />

  City:
  <select name="city"></select>	
 </body>
</html>
