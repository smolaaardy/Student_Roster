<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="/student/contact" method="POST" modelAttribute="contact">
		
		<form:select  path="student">
			<c:forEach items="${students}" var="s">
				 <form:option value="${s}">
				 	${s.firstName} ${s.lastName}
				 </form:option>
	    	</c:forEach>
		</form:select>
	
		<form:label path="address">address</form:label>
		<form:errors path="address"/>
		<form:input path="address"/><span class="req">*</span>
    <p>
        <form:label path="city">city</form:label>
        <form:errors path="city"/>
        <form:input path="city"/>
    </p>
     <p>
        <form:label path="state">state</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>