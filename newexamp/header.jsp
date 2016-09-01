<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
	<c:if test="${!empty user_info}">
		<a href="logout.do">Logout</a>
	</c:if>

	<c:if test="${empty user_info}">
		<a href="showlogin.do">Login</a>
		<a href="showregister.do">Register</a>
	</c:if>

	<br />

	>${!empty user_info}<
</div>

