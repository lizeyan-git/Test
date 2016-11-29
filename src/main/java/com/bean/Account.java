package com.bean;

public class Account {

	private Long id;
	private String username;
	private String password;
	private String email;
	private String phone;
	
	
	
	public Account() {
		super();
	}
	public Account(String username, String password, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	

}
