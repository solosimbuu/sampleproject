<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

 header {
        background-color:blue;
        color: white;
        text-align: center;
        padding: 20px 0;
        font-size: 50px;
    }
   nav {
        background-color: blue;
        overflow: hidden;
        font-size: 18px;
    }

    nav a {
        float: left;
        display: block;
        color: white;
        padding: 14px 20px;
        text-align: center;
        text-decoration: none;
    }

    nav a:hover {
        background-color:red ;
    }

    /* Active Link Styling */
    nav a.active {
        background-color: #2980b9;
    }

    /* Table Styling */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #2c3e50;
        color: white;
    }

    td {
        background-color: #ecf0f1;
    }

    /* Button Styling */
    button {
        background-color: #27ae60;
        color: white;
        padding: 8px 16px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #2ecc71;
    }
   


</style>
<body>
<header style='color:red; text-align:center;font-size:50px;'>BEST HOSPITAL</header>
<nav>
<a href=dashboard.html>Dashboard</a>
<a href=login.html>Logout</a>
</nav>

<h1>All Doctors</h1>
<table border=1>
<tr>
<th>DoctorID</th>
<th>Name</th>
<th>Age</th>
<th>Mobile</th>
<th>Department</th>
<th>Experience</th>
<th>Availability</th>
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
	PreparedStatement statement=connection.prepareStatement ("Select * from hospital.doctor");
	
	//STEP5 	// EXECUTE QUERY
	
	ResultSet resultSet=statement.executeQuery();
	while(resultSet.next())
	{
	int id=resultSet.getInt("doctorID");
	String name=resultSet.getString("name");
	int age=resultSet.getInt("age");
	Long mobile=resultSet.getLong("mobile");
	String department=resultSet.getString("department");
	int experience=resultSet.getInt("experience");


boolean availability=resultSet.getBoolean("availability");

%>
<td><%= id%></td>
<td><%= name%></td>
<td><%= age%></td>
<td><%= mobile%></td>
<td><%= department%></td>
<td><%= experience%></td>
<td><%= availability%></td>


<td>
<%if(availability){%>
<form action="makeDoctorAvailable" method="post">
<input type="hidden" name="id" value="<%= id%>">
<button type="submit">Marks as Available</button> 
</form>
<%}else{ %>
<% } %>

<%if(!availability){%>
<form action="makeDoctorUnAvailable" method="post">
<input type="hidden" name="id" value="<%= id%>">
<button type="submit">Marks as UnAvailable</button>
</form>
<%}else{ %>
<%}%>

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