package com.modal;

public class City {

	private int id;
	private String state_id;
	private String city_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState_id() {
		return state_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", state_id=" + state_id + ", city_name=" + city_name + "]";
	}
}
