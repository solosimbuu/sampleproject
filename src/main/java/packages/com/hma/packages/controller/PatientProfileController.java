package packages.com.hma.packages.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packages.com.hma.packages.service.ProfileService;
import packages.com.hma.packages.services.impl.ProfileServiceImpl;
@WebServlet("/createPatientProfile")
public class PatientProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("controller works");
		ProfileService service=new ProfileServiceImpl();
		service.CreatePatientProfile(req,resp);
		//service.CreateDoctorProfile(req,resp);

	}

}
