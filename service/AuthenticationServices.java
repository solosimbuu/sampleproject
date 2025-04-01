package com.hma.packages.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public interface AuthenticationServices {
public void signUp(HttpServletRequest req,HttpServlet res);
public void login(HttpServletRequest req,HttpServlet res);

}
