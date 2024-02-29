package com.dao.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionProvider;
import com.connection.JdbcBaseDao;
import com.dao.UserDao;
import com.modal.User;


public class UserJdbcDao extends JdbcBaseDao implements UserDao {

	
		
		public UserJdbcDao (Connection connection) {
			
				this.connection= connection;
			}
		@Override
		public boolean checkUserExist(String user_id, String password) throws SQLException {
			String sqlQuery = "SELECT id FROM usercred WHERE user_id=? AND password=?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			
			ps.setString(1, user_id);
			ps.setString(2, password);
			//excuteQuery is used to fetch the records from table
//			excute query is used to excute select query//
			
			ResultSet rs= ps.executeQuery();
			
//			we are using ternary opertor to return
//			bacause query will return only one row//
			
			return rs.next()?true:false;
		}
		
		@Override
		public int save(User user) throws SQLException {
			
			int status=0;
			try { 
				
				connection=ConnectionProvider.getConnection();
				StringBuffer sqlQuery = new StringBuffer();
				sqlQuery.append("INSERT INTO user_details");
				sqlQuery.append("(userid,password,firstname,lastname,fullname,address,contact,gender,stateid,cityid,email,dob,registration_date,last_modified)");
				sqlQuery.append("VALUES");
				sqlQuery.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
				PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
				ps.setString(1, user.getUserid());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstname());
				ps.setString(4, user.getLastname());
				ps.setString(5,user.getFullname());
				ps.setString(6, user.getAddress());
				ps.setString(7, user.getContact());
				ps.setString(8, user.getGender());
				ps.setInt(9, user.getStateid());
				ps.setInt(10, user.getCityid());
				ps.setString(11, user.getEmail());
				ps.setString(12, user.getDob());
				ps.setString(13, user.getRegistration_date());
				ps.setString(14, user.getLast_modify());
				
					
			
				int result = ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return status;
			}

		}
		
		@Override
		public ArrayList<User> getAll() throws SQLException{
			ArrayList< User > userList = new ArrayList<User>();
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("SELECT ");
			sqlQuery.append("id,userid,password,firstname,lastname,fullname,address,contact,gender,stateid,cityid,email,dob,registration_date,last_modified ");
			sqlQuery.append("FROM user_details ");
			
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setFullname(rs.getString("fullname"));
				user.setAddress(rs.getString("address"));
				user.setContact(rs.getString("contact"));
				user.setGender(rs.getString("gender"));
				user.setStateid(rs.getInt("stateid"));
				user.setCityid(rs.getInt("cityid"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getString("dob"));
				user.setRegistration_date(rs.getString("registration_date"));
				user.setLast_modify(rs.getString("last_modified"));
				
				userList.add(user);
				
			}
			return userList;
						}
		@Override
		public User findUserById(int id) throws SQLException{
			User user = null;
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("SELECT ");
			sqlQuery.append("id,firstname,lastname,fullname,address,contact,gender,stateid,cityid,email,dob,registration_date,last_modified ");
			sqlQuery.append("FROM user_details ");
			sqlQuery.append("WHERE id="+id);
		
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());

			
			
			ResultSet rs = ps.executeQuery();
		
	        if (rs.next()) {
	        	 user = new User();
	        	user.setId(rs.getInt("id"));
//	        user.setUserid(rs.getString("user_id"));
//	        user.setPassword(rs.getString("password"));
	        user.setFirstname(rs.getString("firstname"));
	        user.setLastname(rs.getString("lastname"));
	        user.setFullname(rs.getString("fullname"));
	        user.setAddress(rs.getString("address"));
	        user.setContact(rs.getString("contact"));
	        user.setGender(rs.getString("gender"));
	        user.setStateid(rs.getInt("stateid"));
	        user.setCityid(rs.getInt("cityid"));
	        user.setEmail(rs.getString("email"));
	        user.setDob(rs.getString("dob"));
	        user.setRegistration_date(rs.getString("registration_date"));
	        user.setLast_modify(rs.getString("last_modified"));
	        		
	        }
			return user;
			
		}
		@Override
		public boolean getAll(String id, String user_id, String password, String firstName, String lastName,
				String address, String email, String mobile_no) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int updateuser(User user) throws SQLException {
			 int status=0;
			 
			try {
				
				connection= ConnectionProvider.getConnection();
				
				StringBuffer sqlQuery = new StringBuffer();
				sqlQuery.append("UPDATE user_details " );
				sqlQuery.append(" SET  firstname=?,lastname=?,address=?,contact=?,gender=?,stateid=?,cityid=?,email=?,dob=?,registration_date=?,last_modified=? " );
				sqlQuery.append(" WHERE id=? " );
				
	          PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
	         
//	          ps.setString(1, user.getUserid());
//				ps.setString(2, user.getPassword());
				ps.setString(1, user.getFirstname());
				ps.setString(2, user.getLastname());
//				ps.setString(5,user.getFullname());
				ps.setString(3, user.getAddress());
				ps.setString(4, user.getContact());
				ps.setString(5, user.getGender());
				ps.setInt(6, user.getStateid());
				ps.setInt(7, user.getCityid());
				ps.setString(8, user.getEmail());
				ps.setString(9, user.getDob());
				ps.setString(10, user.getRegistration_date());
				ps.setString(11, user.getLast_modify());
				 ps.setInt(12, user.getId());
				
				int result = ps.executeUpdate();
			
		        	return result;	
				
			} catch (Exception e) {
				e.printStackTrace();
				return status;
				
			}
			
			
		}
		@Override
		public User updateuser() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int deleteUserByid(int id) throws SQLException {
			int responce=0;
			
			try {
				User user = null;
				String sqlQuery="DELETE FROM user_details WHERE id= "+id;
				PreparedStatement ps = connection.prepareStatement(sqlQuery);
				responce=ps.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			return responce;
			
		}
		
		

		
		
		
		
	
}
