package com.controller.userM;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commonUtils.Keys;
import com.connection.ConnectionProvider;
import com.dao.MasterDao;
import com.dao.jdbcDao.JDBCMasterDao;
import com.modal.City;

public class OpenRegistrationController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			
			Boolean isActive =(Boolean) session.getAttribute(Keys.ISLOGGEDIN);
			if(isActive !=null && isActive!= false) {
				
			
			MasterDao masterDao = new JDBCMasterDao(ConnectionProvider.getConnection());
			List<com.modal.State> stateList = masterDao.getAllState();
			List<City> cityList = masterDao.getAllCity();
			req.setAttribute("stateList", stateList);
			req.setAttribute("cityList", cityList);
			RequestDispatcher rd=req.getRequestDispatcher("/view/pages/adduser.jsp");
			rd.include(req, resp);
		
			}else {
				PrintWriter out = resp.getWriter();
				out.append("<b> user Is Not Logged In </b>");
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	}
