<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>List of Users</title>

</head>

<body>

	<table border="1" align="center" style="width: 50%">

		<thead>

			<tr>

				<th>User Id</th>

				<th>Name</th>

				<th>Address1</th>

				<th>Address2</th>
				
				<th>Zipcode</th>

				<th>Ciy</th>

				<th>Country</th>
                
                <th>Action</th>
			</tr>

		</thead>

		<tbody>

			<c:forEach var="users" items="${users}">

				<tr>
<!-- [{customer_id=7, name=Advik, address1=abc, address2=null, zip_code=abc, city=abc, country=abc}] -->
					<td>${users.customer_id}</td>

					<td>${users.name}</td>

					<td>${users.address1}</td>

					<td>${users.address2}</td>
					
					<td>${users.zip_code}</td>

					<td>${users.city}</td>

					<td>${users.country}</td>
					
					<td><a  href="http://localhost:8080/mySpringWeb/Register?id=${users.customer_id}">Edit</a>
					/<a  href="http://localhost:8080/mySpringWeb/Delete?id=${users.customer_id}">Delete</a></td>

				</tr>

			</c:forEach>
         
		</tbody>

	</table>
<a  href="http://localhost:8080/mySpringWeb/home">Main Page</a>
</body>

</html>
