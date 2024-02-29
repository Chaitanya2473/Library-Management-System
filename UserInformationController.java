package com.controller.userM;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.MasterDao;
import com.dao.UserDao;
import com.dao.jdbcDao.JDBCMasterDao;
import com.dao.jdbcDao.UserJdbcDao;
import com.modal.City;
import com.modal.User;

public class UserInformationController extends HttpServlet {

	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Connection connection = null;
	
	
	try {
		
		connection = ConnectionProvider.getConnection();
		MasterDao masterDao = new JDBCMasterDao(ConnectionProvider.getConnection());

		List<com.modal.State> stateList = masterDao.getAllState();
		List<City> cityList = masterDao.getAllCity();
		req.setAttribute("stateList", stateList);
		req.setAttribute("cityList", cityList);
		String id = req.getParameter("id");
		UserDao userDao = new UserJdbcDao(connection);
		
		User user = userDao.findUserById(Integer.parseInt(id));
		req.setAttribute("userDetails", user);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/pages/edituser.jsp");
		rd.include(req, resp);
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}

}