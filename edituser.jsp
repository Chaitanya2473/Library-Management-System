<%@page import="com.modal.User"%>
<%@page import="com.modal.City"%>
<%@page import="com.modal.State"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>

<%
 List<State> stateList = (List<State>)request.getAttribute("stateList");
List<City> cityList = (List<City>)request.getAttribute("cityList");

User user = (User)request.getAttribute("userDetails");

%>


</head>
<body  bgcolor="Lightskyblue">
<br>

<form action="UpdateUser" >
<input type="hidden" name="id" value="<%= user.getId()%>">
<br>
<label>UserId :</label>  
   <input type="text" name="userid" value="<%= user.getUserid() %>" size="10"/> <br> <br>  
<br>  
<label>Password :</label>   
<input type="Password" id="pass" name="password" value="<%= user.getPassword()%>"> <br>   
<br> <br> 

<label>FirstName</label>
<input type="text" name="firstname" value="<%= user.getFirstname() %>" size="15"/><br>

<label>LastName</label>
<input type="text" name="lastname" value="<%= user.getLastname() %>" size="15"/><br>


<label>Address</label>
<br>
<textarea rows="5" cols="80" name="address"></textarea>
<br>
<label> State: </label>   
<select name="stateId">
	<option value="0"> Select State</option>
	<%for(State state : stateList){ %>
		<!-- expression tag -->
		
		<%if(state.getId()== user.getStateid()){ %>
		<option value="<%= state.getId() %>" selected> <%=state.getState_name() %></option>
		
		<%}else { %>
		<option value="<%= state.getId() %>"> <%=state.getState_name() %></option>
		<%} %>
	<%} %>
</select>
 


<label>  City :  </label> 
<select name="cityId">
	<option value="0"> Select City</option>
	<%for(City city: cityList){%>
	
	<%if(city.getId()== user.getCityid()){ %>
	<option value="<%= city.getId()%>" selected> <%= city.getCity_name() %></option>
	
	<%}else{ %>

	<option value="<%= city.getId() %>"> <%= city.getCity_name() %></option>
	<%} %>
   <%} %>
</select>
<label>Contact</label>
<input type="text" name="Contact" value="<%= user.getContact() %>" size="15"/><br>

<label>E-mail</label>
<input type="email" name="E-mail" value="<%= user.getEmail() %>" size="15"/><br>

<label>Date of Birth</label>
<input type="date" name="dob" value="<%=  user.getDob() %>" /><br>


<label> Gender : </label> 
<br>  
<input type="radio" name="gender" value="MALE"/> Male <br>  
<input type="radio" name="gender" value="FEMALE" /> Female <br>  
<input type="radio" name="gender" value="OTHER" /> Other  
<br>

<label>RegistrationDate</label>
<input type="date" name="registration_date" value="<%= user.getRegistration_date() %>" /><br>

<label>LastModified</label>
<input type="date" name="last_modified"  value="<%= user.getLast_modify()%>"/><br>

<input type="Submit" value="Update" />  


</form>

</body>
</html>