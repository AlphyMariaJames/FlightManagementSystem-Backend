package com.flight.entity;

public class User {
	private Long id;
	private String username;
	private String email;
	private String passsword;
	
	private ERole role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String username, String email, String passsword, ERole role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.passsword = passsword;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", passsword=" + passsword + ", role="
				+ role + "]";
	}
	
}
