package com.controller.userM;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commonUtils.Keys;
import com.commonUtils.Validate;
import com.connection.ConnectionProvider;
import com.dao.UserDao;
import com.dao.jdbcDao.UserJdbcDao;

public class LoginUserController extends HttpServlet {

	
	private UserDao userDao;
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection= null;
    /* session will be null untill user is not validated*/
    HttpSession session = null;
		try {

			String user_id = req.getParameter("user_id");
			String password = req.getParameter("password");
			/**
			 * validating the userid pass for check method if it is empty we will throw the exception and catch block will catch the exception 
			 * **/
			if(Validate.isEmpty(user_id)&& Validate.isEmpty(password)) {
				throw new InvalidObjectException("object is in valid");
			}
			 connection = ConnectionProvider.getConnection();
			userDao = new UserJdbcDao(connection);
			
			if(userDao.checkUserExist(user_id, password)) {
				
				session = req.getSession();
				session.setAttribute(Keys.ISLOGGEDIN, true);
				
				
				/* key   value*/
				RequestDispatcher rd = req.getRequestDispatcher("view/pages/maindashboard.jsp");
				rd.include(req, resp);
			
			}
			
				
			else {
				RequestDispatcher rd = req.getRequestDispatcher("view/pages/login.jsp");
				rd.include(req, resp);
				PrintWriter out = resp.getWriter();
				out.print("<b> Invalid Credentials</b>");
			}
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("view/pages/login.jsp");
			rd.include(req, resp);
		PrintWriter out = resp.getWriter();
		out.print("<b> userid and password cannot be empty</b>");
		System.out.println(e.getLocalizedMessage());
		e.printStackTrace();
		}
	}
}
