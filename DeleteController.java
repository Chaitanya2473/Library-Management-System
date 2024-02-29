package com.controller.userM;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.UserDao;
import com.dao.jdbcDao.UserJdbcDao;

public class DeleteController  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		  try {
			Connection  connection= ConnectionProvider.getConnection();
			  UserDao userDao = new UserJdbcDao(connection);
				int id= Integer.parseInt(req.getParameter("id"));
				
				int result =userDao.deleteUserByid(id);
			if(result>0)
			{
		RequestDispatcher rd = req.getRequestDispatcher("usermanager");
				rd.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
