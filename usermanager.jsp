<%@page import="com.modal.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userList");

%>
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<h1>User Panel</h1>
	<button style="background-color:Green;"><a href="openregistration">Add User</a></button>
	<table>
		<thead>
			<tr>
				<th>sr.no </th>
				<th>first name </th>
				<th>Last name </th>
				<th>Address</th>
				<th>Contact</th>
				<th>Gender</th>
				<th>Email</th>
				<th> Dob</th>
				<th>edit</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
		<% if(userList != null && !userList.isEmpty()){ %>
				<% int srNumber =1;
					for(User user : userList){%>
					<tr>
						<td><%= srNumber %></td>
						<td><%= user.getFirstname() %></td>
						<td><%= user.getLastname() %></td>
						<td> <%= user.getAddress() %></td>
						<td> <%= user.getContact() %></td>
						<td> <%= user.getGender() %></td>
						<td> <%= user.getEmail() %></td>
						<td> <%= user.getDob() %></td>									
						<td><a href ="userinformation?id=<%=user.getId() %>">edit</a></td>
						<td> <a href ="deleteinformation?id=<%=user.getId() %>">delete</a></td>
					</tr>
					<%
					srNumber++;
			 	}%> 
		<% }else{ %>
				<tr>No Record Found</tr>
			<% }%>
		</tbody>
	</table>
	</div>
</body>
</html>