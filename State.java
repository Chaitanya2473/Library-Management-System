package com.modal;

public class State{

	private int id;
	private String state_name;
	@Override
	public String toString() {
		return "State [id=" + id + ", state_name=" + state_name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	
}
