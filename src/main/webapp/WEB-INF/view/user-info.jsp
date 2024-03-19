<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2>User ${userName}</h2>
<form:form action="saveUser" modelAttribute="user">

<form:hidden path="id"/>
<div>Name:<form:input path="name"/></div>

<div>
Surname:<form:input path="email"/>
<form:errors path="email"/>
</div>

<div><input type="submit" value="ok"/></div>
</form:form>

</body>
</html>