<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.error{
color: red;
font-size: 15px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<h1>Enter Account Details</h1>
<form:form commandName="aNewAccount" action="accountCreated" method="post">
<table>
<tr>
<td>First Name: <form:input type="text" path="firstName" name="firstName"/>
<form:errors path="firstName" cssClass="error"/>
</td></tr>
<tr><td>Last Name: <form:input type="text" path="lastName" name="lastName"/></td></tr>
<tr><td>Address: <form:input type="text" path="address" name="address"/>
<form:errors path="address" cssClass="error"/>
</td></tr>
<tr><td>Email: <form:input type="text" path="email" name="email"/>
<form:errors path="email" cssClass="error"/>
</td></tr>
<tr><td>Submit: <input type="submit" value ="submit" name="submit"/></td></tr>

</table>

</form:form>
</body>
</html>