package packages.com.hma.packages.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DoctorService {
	public void doctorMakeAvailability(HttpServletRequest req,HttpServletResponse resp);
	public void doctorMakeUnAvailability(HttpServletRequest req,HttpServletResponse resp);

}
