package packages.com.hma.packages.services.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packages.com.hma.packages.service.ProfileService;

public class ProfileServiceImpl implements ProfileService{

	@Override
	public void CreatePatientProfile(HttpServletRequest req, HttpServletResponse resp) {
		
		String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
	    String USERNAME="root"; // THIS IS UR SQL USERNAME
	    String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
	    String INSERTSQLQUERRY="insert into hospital.patient(name,age,address,mobile,gender) values(?,?,?,?,?)";
	
	    try {
	    	//STEP 1 CREATING DRIVER
	    			//Class.forName("com.mysql.cj.jdbc.Driver");
	    			Class.forName(JDBCDRIVER); // load the jdbc driver

	    	// STEP 3  CREATE THE CONNECTION CLASS
	    			
	    			 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
	    			
	    			Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
//	    		STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
	    			PreparedStatement statement=connection.prepareStatement (INSERTSQLQUERRY);
	    			
	    			statement.setString(1, req.getParameter("name"));
	    			statement.setInt(2,Integer.parseInt(req.getParameter("age")));
	    			statement.setString(3, req.getParameter("address"));
	    			statement.setLong(4,Long.parseLong(req.getParameter("mobile")));
	    			statement.setString(5, req.getParameter("gender"));
	    	//STEP5 	// EXECUTE QUERY
	    			int noOfRowsAffected=statement.executeUpdate();
	    			resp.setContentType("text/html"); // STEP1 -- HTML TXT ADD

	    			if(noOfRowsAffected>=1){
	    				
	    	          resp.sendRedirect("dashboard.html");
	    				
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
	public void createDoctorProfile(HttpServletRequest req, HttpServletResponse resp) {
		String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/hospital"; //  url of database of sql
	    String USERNAME="root"; // THIS IS UR SQL USERNAME
	    String PASSWORD="Password123@"; // THIS IS SQL WORKBENCH PASSWORD OF USER
	    String INSERTTSQLQUERRY="insert into hospital.doctor(name,age,address,mobile,gender,department,experience,availability) values(?,?,?,?,?,?,?,?)";
	
	    try {
	    	//STEP 1 CREATING DRIVER
	    			//Class.forName("com.mysql.cj.jdbc.Driver");
	    			Class.forName(JDBCDRIVER); // load the jdbc driver

	    	// STEP 3  CREATE THE CONNECTION CLASS
	    			
	    			 //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
	    			
	    			Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/conncection","root","Password123@");
//	    		STEP 4 PREPARED QUERY// WITH STEP4 GET THE PARAMETER
	    			PreparedStatement statement=connection.prepareStatement (INSERTTSQLQUERRY);
	    			
//	    			statement.setString(1, req.getParameter("name"));
//	    			statement.setInt(2,Integer.parseInt(req.getParameter("age")));
//	    			statement.setString(3, req.getParameter("address"));
//	    			statement.setString(4,req.getParameter("mobile"));
//	    			statement.setString(5, req.getParameter("gender"));
//	    			statement.setString(6, req.getParameter("department"));
//
//	    			statement.setString(7,req.getParameter("experience"));
//	    			statement.setInt(8,Integer.parseInt(req.getParameter("availability")));
	    			statement.setString(1, req.getParameter("name"));
	    			statement.setInt(2,Integer.parseInt(req.getParameter("age")));
	    			statement.setString(3, req.getParameter("address"));
	    			statement.setLong(4,Long.parseLong(req.getParameter("mobile")));
	    			statement.setString(5, req.getParameter("gender"));
	    			statement.setString(6, req.getParameter("department"));
	    			statement.setInt(7,Integer.parseInt(req.getParameter("experience")));
	    			boolean available=req.getParameter("availability") !=null ;
	    			System.out.println(available);
                    statement.setBoolean(8,available );	   		
	    	//STEP5 	// EXECUTE QUERY
	    			int noOfRowsAffected=statement.executeUpdate();
	    			resp.setContentType("text/html"); // STEP1 -- HTML TXT ADD

	    			if(noOfRowsAffected>=1){
	    				
	    	          resp.sendRedirect("dashboard.html");
	    				
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
	}


