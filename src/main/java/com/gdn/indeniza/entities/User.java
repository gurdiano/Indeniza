package com.gdn.indeniza.entities;

import java.util.Date;
import java.util.Objects;

public class User {
	
	private Long id;
	private String name;
	private String password;
	private String email;
	private Date creation;
	
	public User () {
		
	}

	public User(Long id, String name, String password, String email, Date creation) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.creation = creation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}
	
}