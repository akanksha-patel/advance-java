<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.*" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/common.css" />
  <script type="text/javascript" src="js/ajax.js"> </script>
  <script type="text/javascript" src="js/profile.js"> </script>

  
  <title>Home Page</title>
 </head>
 <body>
  <% UserInfo userInfo = (UserInfo)session.getAttribute("user_info"); %>

	<%@ include file="header.jsp" %>
  <H1>Welcome User!</H1>
	<form action="abc.do">
	  <table border="1" width="80%">
		<tr>
			<td>User Name :</td>
			<td><input type="text" name="unm" value="${user_info.user.userName}" /></td>
		</tr>	
		<tr>
			<td>Email : </td>
			<td><input type="text" name="eml" value="${user_info.user.email}" /></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type="password" name="pwd" value="dotdotdot" /></td>
		</tr>
		<tr>
			<td>Dob : </td>
			<td>
				<input type="text" name="dob" value="${user_info.dob}" id="dob_fld" placeholder="yyyy-mm-dd" />
				<img src="images/save.gif" id="dob_save_btn" />
			</td>
		</tr>
		<tr>
			<td>Address : </td>
			<td>
				<textarea rows="6" cols="20" name="addr" id="addr"><%= userInfo!=null?userInfo.getAddress():"" %></textarea>
				<img src="images/save.gif" id="addr_save_btn" />
			</td>
		</tr>
		<tr>
			<td>City : </td>
			<td>
				<select id="city">
					<option value="0">Select</option>
					<c:forEach var="city" items="${cities}">
						<c:choose>
							<c:when test="${city.cityId==user_info.city.cityId}">
								<option value="${city.cityId}" selected="selected">${city.city}</option>
							</c:when>
							<c:otherwise>
								<option value="${city.cityId}">${city.city}</option>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</select>
				<img src="images/save.gif" id="city_save_btn" />
			</td>
		</tr>
	  </table>
	  <input type="submit" value="Save" />
  </form>
 </body>
</html>
