<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header style='color:red; text-align:center;font-size:50px;'>BEST HOSPITAL</header>
<nav>
<a href=dashboard.html>Dashboard</a>
<a href=login.html>Logout</a>
</nav>
<h1>Appointment profile</h1>
<table border=1>
<tr>
<th>Department</th>
<th>PatientID</th>
<th>payment</th>
<th>dateAndtime</th>
<th>BookingHistory</th>
</tr>

<tr>
<%
try{
	String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
	String PASSWORD="Password123@";
    String USERNAME="root"; // THIS IS UR SQL USERNAME  String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
   // String DOCTORS_SQLQUERRY="Select * from hospital.doctor";
	//STEP 1 CREATING DRIVER
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName(JDBCDRIVER); // load the jdbc driver

// STEP 3  CREATE THE CONNECTION CLASS
	
	 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
	
	Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
//STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
	PreparedStatement statement=connection.prepareStatement ("select department,patientID,payment,dateAndTime from hospital.appointment");
	
	//STEP5 	// EXECUTE QUERY
	
	ResultSet resultSet=statement.executeQuery();
	while(resultSet.next())
	{
	String department=resultSet.getString("department");
	int patientID=resultSet.getInt("patientID");
	String payment=resultSet.getString("payment");
	String dateAndtime=resultSet.getString("dateAndtime");
	
	
%>
	
<td><%= department%></td>
<td><%= patientID%></td>
<td><%=payment %></td>
<td><%= dateAndtime%></td>

<td>
<form action="BookingHistory.jsp" method="post">
<input type="hidden" name="id" value="<%= patientID%>">
<button type="submit">Appointment History</button>
</form>
</td>
</tr>




	<%
	}

	connection.close();
	} 
	catch(Exception e){
	e.printStackTrace();
	}
	%>
		
</table>





</body>
</html>