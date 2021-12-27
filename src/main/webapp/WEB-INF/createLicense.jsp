<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
<h1>Create New License</h1>
<form:form action="/license/create" method="post" modelAttribute="license">

	<form:select path="person">
		<c:forEach items="${persons}" var="person">
        	<option value="${person.id}">${person.firstName} ${person.lastName}</option>
    	</c:forEach>
	</form:select>
	
    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" path="expirationDate"/>
    </p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>     
        <form:input path="state"/>
    </p>    
    <p>
        <form:label path="number">Number</form:label>
        <form:errors path="number"/>     
        <form:input path="number"/>
    </p>    
    <input type="submit" value="Create"/>
</form:form>  

</body>
</html>