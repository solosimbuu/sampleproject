package packages.com.hma.packages.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProfileService {
	public void CreatePatientProfile(HttpServletRequest req,HttpServletResponse res);
	public void createDoctorProfile(HttpServletRequest req,HttpServletResponse res);
	//public void CreatePatientProfile(HttpServletRequest req, HttpServletResponse resp);

}
