<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2>Task from ${userName}</h2>
<form:form action="saveTask" modelAttribute="task">

<form:hidden path="id"/>
<input type="hidden" name="userId" value="${userId}"/>
<input type="hidden" name="userName" value="${userName}"/>

<div>Name:<form:input path="name"/></div>

<div>
Details:<form:input path="details"/>
</div>

<div><input type="submit" value="ok"/></div>
</form:form>

</body>
</html>