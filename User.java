package com.modal;

public class User {

		

		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getLast_modify() {
		return last_modify;
	}
	public void setLast_modify(String last_modify) {
		this.last_modify = last_modify;
	}
		private int id;
		private String userid;
		private String password;
		private String firstname;
		private String lastname;
		private String fullname;
		private String address;
		@Override
		public String toString() {
			return "User [id=" + id + ", userid=" + userid + ", password=" + password + ", firstname=" + firstname
					+ ", lastname=" + lastname + ", fullname=" + fullname + ", address=" + address + ", contact="
					+ contact + ", gender=" + gender + ", stateid=" + stateid + ", cityid=" + cityid + ", email="
					+ email + ", dob=" + dob + ", registration_date=" + registration_date + ", last_modify="
					+ last_modify + "]";
		}
		private String contact;
		private String gender;
		private int stateid;
		private int cityid;
		private String email;
		private String dob;
		private String registration_date;
		private String last_modify;
		


	
}