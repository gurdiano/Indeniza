package com.gdn.indeniza.entities.enums;

public enum Role {

	MASTER("master"),
	ADMIN("admin"),
	USER("user");

	private String role;
	
	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
