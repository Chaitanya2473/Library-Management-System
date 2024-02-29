package com.controller.userM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commonUtils.Keys;

public class LogoutController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout");
		HttpSession session = request.getSession();
		
		session.removeAttribute(Keys.ISLOGGEDIN);
		session.invalidate();
		
		response.sendRedirect("http://localhost:8080/LMS/");
	}
}
