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


<h1>All Patients History</h1>
<table border=1>
<tr >
<th>PatientID</th>
<th>patientName</th>
<th>PatientAge</th>
<th>patientmobile</th>
<th>patientAddress</th>
<th>dateAndTime</th>
<th>doctorName</th>

<th>department</th>

<th>Payment</th>
<th>Status</th>
</tr>

<tr>

<%
try{
	String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
	String PASSWORD="Password123@";
    String USERNAME="root"; // THIS IS UR SQL USERNAME  String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
    String PATIENTS_SQLQUERRY="SELECT p.patientID, p.name , p.age,p.mobile,p.address, a.dateAndTime,d.name,d.department,a.payment,a.status from hospital.appointment as a join patient as p on a.patientId=p.patientID  join doctor as d on a.doctorID=d.doctorID ";
	/// HERE VERY IMPORTANT ---- SQL QUERY SINGLE LINE ONLY--- DONT USE MULTIPLE QUERRY--- SUPPOSE USE MULTIPLE QUERY MEANS ERROR STRING CLOSE NOT PROPERLY
    
    
    //STEP 1 CREATING DRIVER
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName(JDBCDRIVER); // load the jdbc driver

// STEP 3  CREATE THE CONNECTION CLASS
	
	 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
	
	Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
//STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
	PreparedStatement statement=connection.prepareStatement (PATIENTS_SQLQUERRY);
	
	//STEP5 	// EXECUTE QUERY
	
	ResultSet resultSet=statement.executeQuery();
	while(resultSet.next())
	{
	int patientID=resultSet.getInt("p.patientID");
	String patientName=resultSet.getString("p.name");
	int patientage=resultSet.getInt("p.age");
	Long patientmobile=resultSet.getLong("p.mobile");

	String patientAddress=resultSet.getString("p.address");

	String dateAndTime=resultSet.getString("a.dateAndTime");
	String doctorName=resultSet.getString("d.name");
	String department=resultSet.getString("d.department");
	int payment=resultSet.getInt("a.payment");
	String status =resultSet.getString("a.status");
%>
<td><%= patientID%></td>
<td><%= patientName%></td>
<td><%= patientage%></td>
<td><%= patientmobile%></td>
<td><%= patientAddress%></td>

<td><%= dateAndTime%></td>
<td><%= doctorName%></td>
<td><%= department%></td>

<td><%= payment%></td>
<td><%= status%></td>


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