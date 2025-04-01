package packages.com.hma.packages.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packages.com.hma.packages.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	@Override
	public void doctorMakeAvailability(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			
			String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
			String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
		    String USERNAME="root"; // THIS IS UR SQL USERNAME
		    String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
		    String DOCTORUPDATE_SQLQUERRY="Update doctor set availability=true where doctorID=?";
		    String id=req.getParameter("id");
		    
			//STEP 1 CREATING DRIVER
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(JDBCDRIVER); // load the jdbc driver	
			
			// STEP 2  CREATE THE CONNECTION CLASS
			 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
			Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");

			//STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
			PreparedStatement statement=connection.prepareStatement (DOCTORUPDATE_SQLQUERRY);
			statement.setInt(1,Integer.parseInt(id));
			
			//STEP5 	// EXECUTE QUERY
			int noOfRowsAffected=statement.executeUpdate();
			resp.setContentType("text/html"); // STEP1 -- HTML TXT ADD
		
		if(noOfRowsAffected>=1) {
			 resp.sendRedirect("AllDoctor.jsp");
		}
		
		else {
			System.err.println("something went wrong");
		
		}
		   // STEP 6 CLOSE THE CONNECTION 
		connection.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	

	@Override
	public void doctorMakeUnAvailability(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
try {
			
			String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
			String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
		    String USERNAME="root"; // THIS IS UR SQL USERNAME
		    String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
		    String DOCTORUPDATE_SQLQUERRY="Update doctor set availability=false where doctorID=?";
		    String id=req.getParameter("did");
		    
			//STEP 1 CREATING DRIVER
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(JDBCDRIVER); // load the jdbc driver	
			
			// STEP 2  CREATE THE CONNECTION CLASS
			 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
			Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");

			//STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
			PreparedStatement statement=connection.prepareStatement (DOCTORUPDATE_SQLQUERRY);
			statement.setInt(1,Integer.parseInt(id));
			
			//STEP5 	// EXECUTE QUERY
			int noOfRowsAffected=statement.executeUpdate();
			resp.setContentType("text/html"); // STEP1 -- HTML TXT ADD
		
		if(noOfRowsAffected>=1) {
			 resp.sendRedirect("AllDoctor.jsp");
		}
		
		else {
			System.err.println("something went wrong");
		
		}
		   // STEP 6 CLOSE THE CONNECTION 
		connection.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	}


