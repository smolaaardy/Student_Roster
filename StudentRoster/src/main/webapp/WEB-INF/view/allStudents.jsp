<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/student/new">New Student</a>
<a href="/student/contact">Add Contact Info</a>
<table>
    <thead>
        <tr>
            <th><h3>Name</h3></th>
            <th><h3>Age</h3></th>
            <th><h3>Address</h3></th>
            <th><h3>city</h3></th>
            <th><h3>state</h3></th>
            <th><h3>delete</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student">
        <tr>
        	<td><c:out value="${student.firstName}"/> ${student.lastName}</td>
        	<td>${student.age}</td>
        	<td>${student.contactInfo.address}</td>
        	<td>${student.contactInfo.city}</td>
        	<td>${student.contactInfo.state}</td>
            <td>
            <form action="/student/${student.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>