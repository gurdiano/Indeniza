package com.gdn.indeniza.entities.enums;

public enum Status {
	
	WAITING_DOCUMETATION(1),
	WAITING_APPROVAL(2),
	FINISHED(3);
	
	private int code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Status valueof(int code) {
		for(Status value : Status.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Status code");
	}
}
