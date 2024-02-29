package com.dao.jdbcDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.JdbcBaseDao;
import com.dao.MasterDao;
import com.modal.City;
import com.modal.State;
import com.mysql.jdbc.Connection;

public class JDBCMasterDao extends JdbcBaseDao implements MasterDao {


	public JDBCMasterDao (Connection connection) {
		this.connection= connection;
	}
	
	@Override
	public List<City> getAllCity() throws SQLException{
		ArrayList<City> cityList = new ArrayList<>();
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT ");
		sqlQuery.append("id,state_id,city_name  ");
		sqlQuery.append("FROM citymaster ");
		
		PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			City city = new City();
			city.setId(rs.getInt("id"));
			city.setState_id(rs.getString("state_id"));
			city.setCity_name(rs.getString("city_name"));
			cityList.add(city);
			
		}
		
		return cityList;
	}
	@Override
	public List<State> getAllState() throws SQLException{
		List<State> stateList = new ArrayList<>();
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT ");
		sqlQuery.append("id,state_name ");
		sqlQuery.append("FROM statemaster ");
		
		PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			State state = new  State();
			state.setId(rs.getInt("id"));
			state.setState_name(rs.getString("state_name"));
			stateList.add(state);
		}
		
		return stateList;
	}
	@Override
	public List<City> getCityByStateid() throws SQLException{
		
		ArrayList<City> list = new ArrayList<>();
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT ");
        sqlQuery.append(" id,state_id,city_name");
        sqlQuery.append("FROM citymaster ");
        sqlQuery.append("WHERE state_id=? ");
        
        PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
        ps.setString(1, "state_id");
        ps.setString(2, "state_id");
        
        ResultSet rs = ps.executeQuery();
        City city = new City();
        if (rs.next()) {
       	 city.setCity_name(rs.getString("city_name"));
       	 
		}
		return list;
		
	}

}
