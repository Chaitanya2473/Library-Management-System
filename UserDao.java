package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.modal.User;


public interface UserDao {

	boolean checkUserExist(String userId, String pass) throws SQLException;

	int save (User user ) throws SQLException ;



	ArrayList<User> getAll() throws SQLException;


	boolean getAll(String id, String user_id, String password, String firstName, String lastName, String address,
			String email, String mobile_no);


	User findUserById(int id) throws SQLException;

	User updateuser() throws SQLException;

	int updateuser(User user) throws SQLException;


	int deleteUserByid(int id) throws SQLException;




	

}
