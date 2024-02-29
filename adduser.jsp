<%@page import="com.modal.City"%>
<%@page import="com.modal.State"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<% 
List<State> stateList = (List<State>) request.getAttribute("stateList");
List<City> cityList = (List<City>) request.getAttribute("cityList");

%>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="Lightskyblue">  
<br>  
<br>  
<form action="register" method="post">  
  
<label> Firstname </label>         
<input type="text" name="firstname" size="15"/> <br> <br>  

<label> Lastname: </label>     
<input type="text" name="lastname" size="15"/> <br> <br>  

<label> Address: </label>   
<br>  
<textarea cols="80" rows="5" name="address">  
</textarea>  
<br><br>    
<label> State: </label>   
<select name="stateId">
	<option value="0"> Select State</option>
	<%for(State state : stateList){ %>
		<!-- expression tag -->
		<option value="<%= state.getId() %>"> <%=state.getState_name() %></option>
	<%} %>
</select>
 


<label>  City :  </label> 
<select name="cityId">
	<option value="0"> Select City</option>
	<%for(City city: cityList){%>
	<option value="<%= city.getId() %>"> <%= city.getCity_name() %></option>

<%} %>
</select>
<br> <br>
<label> Contact: </label>         
<input type="text" name="Contact" size="15"/> <br> <br>  

<label> E-mail: </label>         
<input type="email" name="E-mail" size="15"/> <br> <br>

<label> Date of Birth: </label>         
<input type="date" name="dob" /> <br> <br>    
 
<label> Gender : </label> 
<br>  
<input type="radio" name="gender" value="MALE"/> Male <br>  
<input type="radio" name="gender" value="FEMALE" /> Female <br>  
<input type="radio" name="gender" value="OTHER" /> Other  
<br>  

<label>Userid :</label>  
   <input type="text" name="userid" size="10"/> <br> <br>  
<br>  
<label>Password :</label>   
<input type="Password" id="pass" name="password"> <br>   
<br> <br> 
<label>RegistrationDate:</label> 
<input type="date" name="registration_date">
<br><br>
 
 <label>LastModified:</label> 
<input type="date" name="last_modified">
<br><br>
 

<input type="Submit" value="Registration1" />  
</form>  
</body>
</html>