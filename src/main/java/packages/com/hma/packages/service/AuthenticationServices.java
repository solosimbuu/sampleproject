package packages.com.hma.packages.service;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public interface AuthenticationServices {
public void signUp(HttpServletRequest req,HttpServletResponse res);
// here more important httpservlet response put httpservletresponse
public void login(HttpServletRequest req,HttpServletResponse res);

}
