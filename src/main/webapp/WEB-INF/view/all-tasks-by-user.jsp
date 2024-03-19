<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2>All tasks by ${userName}</h2>

<table>
<tr>
<th>Name</th>
<th>Details</th>
<th>Operations</th>
</tr>
<c:url var="addNewTaskByUserButton" value="/addNewTaskByUser">
<c:param name="userId" value="${userId}"/>
<c:param name="userName" value="${userName}"/>
</c:url>
<c:url var="back" value="/">
</c:url>
<c:forEach var="task" items="${allTasks}">

<c:url var="deleteButton" value="/deleteTask">
<c:param name="taskId" value="${task.id}"/>
<c:param name="userId" value="${userId}"/>
<c:param name="userName" value="${userName}"/>
</c:url>

<c:url var="updateButton" value="/updateTask">
<c:param name="taskId" value="${task.id}"/>
<c:param name="userId" value="${userId}"/>
<c:param name="userName" value="${userName}"/>
</c:url>

<tr>
<td>${task.name}</td>
<td>${task.details}</td>
<td>
<input type="button" value="Update" onclick="window.location.href='${updateButton}'">
<input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">
</td>
</tr>
</c:forEach>
</table>
<div>
<input type="button" value="Add" onclick="window.location.href='${addNewTaskByUserButton}'">
</div>
<a href='${back}'>Back to list of users</a>
</body>
</html>