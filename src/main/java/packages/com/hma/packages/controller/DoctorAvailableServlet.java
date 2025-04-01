package packages.com.hma.packages.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import packages.com.hma.packages.service.DoctorService;
import packages.com.hma.packages.services.impl.DoctorServiceImpl;
@WebServlet("/makeDoctorAvailable")
public class DoctorAvailableServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DoctorService service= new DoctorServiceImpl();
		service.doctorMakeAvailability(req,resp);

	}
}
