package com.controller.userM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commonUtils.Keys;
import com.connection.ConnectionProvider;
import com.dao.UserDao;
import com.dao.jdbcDao.UserJdbcDao;
import com.modal.User;

public class FetchUserController extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 Connection connection= null;
 try {
	connection = ConnectionProvider.getConnection();
	 HttpSession session = req.getSession();
	 Boolean isActive = (Boolean) session.getAttribute(Keys.ISLOGGEDIN);
		if(isActive != null && isActive != false) {
			UserDao userDAO = new UserJdbcDao(connection);
			ArrayList<User> userList = userDAO.getAll();
			req.setAttribute("userList", userList);
			RequestDispatcher rd = req.getRequestDispatcher("/view/pages/usermanager.jsp");
			rd.include(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.append("<b> User Is Not Logged In</b>");;
		}
	
} catch (Exception e) {
	e.printStackTrace();
}
	}
}

