package com.controller.userM;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.UserDao;
import com.dao.jdbcDao.UserJdbcDao;
import com.modal.User;
import com.mysql.jdbc.Connection;

public class AddUserController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		
		Connection connection=null;
		



		try {
//		String i= req.getParameter("id");
//	int id= Integer.parseInt(i);
			String userId= req.getParameter("userid");
		String password=req.getParameter("password");
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
//		user.setId(id);
		user.setUserid(userId);
		user.setPassword(password);
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
		UserDao userdao=new UserJdbcDao(connection);
		{
			System.out.println("return");
		}
			int result = userdao.save(user);
			if(result==1)
			{	
				RequestDispatcher rd=req.getRequestDispatcher("usermanager");
			rd.forward(req, resp);
				PrintWriter out=resp.getWriter();
				out.print("<b>REGISTRTION SUCCESSFULL</b>");
			;
			}
			else
			{
				PrintWriter out =resp.getWriter();
			out.append("failed to register");
//			throw new InvalidObjectException("");

			}
			

			
		
		
		}
	catch(Exception e)
	{
		System.out.println(e);
	}
	

	}

	}


