package packages.com.hma.packages.services.impl;






//import java.io.PrintWriter;




//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import packages.com.hma.packages.service.AuthenticationServices;

public class AuthenticationServicesImpl implements AuthenticationServices{
	
	public void signUp(HttpServletRequest req, HttpServletResponse resp) {
		// give variables first directly
		
		String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
	    String USERNAME="root"; // THIS IS UR SQL USERNAME
	    String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
	    String INSERTSQLQUERRY="insert into hospital.authentication(Email,Password) values(?,?)";
	    String email=req.getParameter("email");
		String password=req.getParameter("Password");
	try {
//STEP 1 CREATING DRIVER
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName(JDBCDRIVER); // load the jdbc driver

// STEP 3  CREATE THE CONNECTION CLASS
		
		 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
		
		Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
//	STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
		PreparedStatement statement=connection.prepareStatement (INSERTSQLQUERRY);
		//String email=req.getParameter("email");
		//String password=req.getParameter("Password");
		statement.setString(1,email);
		statement.setString(2,password);
//STEP5 	// EXECUTE QUERY
		int noOfRowsAffected=statement.executeUpdate();
		resp.setContentType("text/html"); // STEP1 -- HTML TXT ADD

		if(noOfRowsAffected>=1){
			//resp.setContentType("text/html"); // STEP1 -- HTML TXT ADD
			//PrintWriter outputMessage =resp.getWriter(); //STEP2 --- HTML TEXT OUTPUT MESSAGE
          resp.sendRedirect("login.html");
			
		}
		else {
			System.err.println("something went wrong");
		}
// STEP 6 CLOSE THE CONNECTION 
		connection.close();

	}
		
	
	catch(Exception e){
	e.printStackTrace();
	}
	
	}

	@Override
	public void login(HttpServletRequest req, HttpServletResponse resp) {
		// give variables first directly
		
		String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
	    String USERNAME="root"; // THIS IS UR SQL USERNAME
	    String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
	    String SQLExecuteQUERY="select * from hospital.authentication where email=? and password=?";
	    String email=req.getParameter("email");
		String password=req.getParameter("Password");
		
		try {
			//STEP 1 CREATING DRIVER
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(JDBCDRIVER); // load the jdbc driver

	// STEP 3  CREATE THE CONNECTION CLASS
			
			 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
			
			Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
//		STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
			PreparedStatement statement=connection.prepareStatement (SQLExecuteQUERY);
			//String email=req.getParameter("email");
			//String password=req.getParameter("Password");
			statement.setString(1,email);
			statement.setString(2,password);
	//STEP5 	// EXECUTE QUERY
		    ResultSet resultset=statement.executeQuery();
			
			while(resultset.next()) {
				HttpSession session= req.getSession();
				session.setAttribute("userID",resultset.getInt("userID"));
				resp.sendRedirect("dashboard.html");
				
			}
	//STEP6 CLOSE THE CONNECTION
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}}
	

