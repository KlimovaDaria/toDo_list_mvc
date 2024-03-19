<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2>All users</h2>
<table>

<tr>
<th>Name</th>
<th>Email</th>
<th>Operations</th>
</tr>

<c:forEach var="user" items="${allUsers}">
<c:url var="updateButton" value="/updateUser">
<c:param name="userId" value="${user.id}"/>
</c:url>
<c:url var="deleteButton" value="/deleteUser">
<c:param name="userId" value="${user.id}"/>
</c:url>
<c:url var="allTasksButton" value="/allTasksByUser">
<c:param name="userId" value="${user.id}"/>
<c:param name="userName" value="${user.name}"/>
</c:url>
<tr>
<td>${user.name}</td>
<td>${user.email}</td>
<td>
<input type="button" value="Update" onclick="window.location.href='${updateButton}'">
<input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">
<input type="button" value="Tasks" onclick="window.location.href='${allTasksButton}'">
</td>
</tr>
</c:forEach>
</table>
<div>
<input type="button" value="Add" onclick="window.location.href='addNewUser'">
</div>
</body>
</html>