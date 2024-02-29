package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.modal.City;
import com.modal.State;

public interface MasterDao {

	List<City> getAllCity() throws SQLException;

	List<State> getAllState() throws SQLException;


	List<City> getCityByStateid() throws SQLException;


}
