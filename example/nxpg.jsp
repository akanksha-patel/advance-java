<%@ page import="model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> New Document </TITLE>
  
 </HEAD>

 <BODY>
 
 
  
  <!-- Case 2: -->
  <%--
  <jsp:useBean id="prsn"  class="model.Employee" scope="request">
	<jsp:setProperty name="prsn" property="name" value='<%= request.getParameter("nm") %>' />
	<jsp:setProperty name="prsn" property="age" value='<%= request.getParameter("ag") %>' /><!-- Type Mismatch -->
	<jsp:setProperty name="prsn" property="empId" value='<%= request.getParameter("empid") %>' /><!-- Type Mismatch -->
  </jsp:useBean>
  --%>

  <!-- Case 3: -->
  <%--
  <jsp:useBean id="prsn"  class="model.Employee" scope="request">
	<jsp:setProperty name="prsn" property="name" value='<%= request.getParameter("nm") %>' />
	<jsp:setProperty name="prsn" property="age" value='<%= Integer.parseInt(request.getParameter("ag")) %>' />
	<jsp:setProperty name="prsn" property="empId" value='<%= Integer.parseInt(request.getParameter("empid")) %>' />
  </jsp:useBean>
  --%>

  <!-- Case 4: -->
 <%--
  <jsp:useBean id="prsn"  class="model.Employee" scope="request">
	<jsp:setProperty name="prsn" property="name"  />
	<jsp:setProperty name="prsn" property="age"  />
	<jsp:setProperty name="prsn" property="empId" />
  </jsp:useBean><br />
  --%>

  <!-- Case 5: -->
  
  <jsp:useBean id="prsn"  class="model.Employee" scope="request">
	<jsp:setProperty name="prsn" property="*"  />
  </jsp:useBean>
  


  Emp Name: <jsp:getProperty name="prsn" property="name" /><br />
  Emp Age: <jsp:getProperty name="prsn" property="age" /><br />
  Emp Id: <jsp:getProperty name="prsn" property="empId" />


 </BODY>
</HTML>
