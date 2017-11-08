<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.11.2017
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>

<style type="text/css">
    table, th, td {
        border: solid black;
    }
    th {
        background-color: grey;
    }
    .greenTD {
        color: green;
    }
    .redTD {
        color: red;
    }
</style>
<table>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Exceed</th>
        <th></th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach items="${mealsWithExceededList}" var="meal">
        <tr class="${meal.exceed eq true ? "greenTD" : "redTD"}" >
            <td><c:out value="${meal.id}"/></td>
            <td><c:out value="${meal.localDate} ${meal.localTime}"/></td>
            <td><c:out value="${meal.description}"/></td>
            <td><c:out value="${meal.calories}"/></td>
            <td><c:out value="${meal.exceed}"/></td>
            <td><a href="/topjava/meals/edit/${meal.id}">Edit</a></td>
            <td><a href="/topjava/meals/delete/${meal.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
