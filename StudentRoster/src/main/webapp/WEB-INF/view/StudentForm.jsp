<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="/student/new" method="POST" modelAttribute="student">
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName"/>
		<form:input path="firstName"/><span class="req">*</span>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
     <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>