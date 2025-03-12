<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Recommendations</title>
</head>
<body>
    <h1>Your Top Matches</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Interests</th>
        </tr>
        <c:forEach items="${recommendations}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.interests}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/">Back to Home</a>
</body>
</html>