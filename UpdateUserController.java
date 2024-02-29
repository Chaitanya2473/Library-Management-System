package com.controller.userM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.UserDao;
import com.dao.jdbcDao.UserJdbcDao;
import com.modal.User;

public class UpdateUserController  extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection =null;
		
		try {
			String i= req.getParameter("id");
		int id= Integer.parseInt(i);
//			String userId= req.getParameter("userid");
//			String password=req.getParameter("password");
			String firstname=req.getParameter("firstname");
			String lastname=req.getParameter("lastname");
			
			
			String address=req.getParameter("address");
			String contact=req.getParameter("Contact");
			String gender=req.getParameter("gender");
			String r = req.getParameter("stateId");
			int stateid= Integer.parseInt(r);
			String p= req.getParameter("cityId");
			int cityid= Integer.parseInt(p);
			String email=req.getParameter("E-mail");
			String dob=req.getParameter("dob");
			String regDate=req.getParameter("registration_date");
			String lastMod=req.getParameter("last_modified");
			

			User user=new User();
			user.setId(id);
//			user.setUserid(userId);
//			user.setPassword(password);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setAddress(address);
			user.setContact(contact);
			user.setGender(gender);
			 user.setStateid(stateid);
			 user.setCityid(cityid);
			user.setEmail(email);
			user.setDob(dob);
			user.setRegistration_date(regDate);
			user.setLast_modify(lastMod);
		
			connection=ConnectionProvider.getConnection();
			
			System.out.println(user.toString());
			UserDao userdao=new UserJdbcDao(connection);
			
				 userdao.updateuser(user);
			RequestDispatcher rd= req.getRequestDispatcher("usermanager");
			rd.forward(req, resp);
			
			
			}
		catch(Exception e) {
			
			e.printStackTrace();
	
}
		

		}

	}

