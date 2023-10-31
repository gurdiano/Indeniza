package com.gdn.indeniza.entities;

import java.util.Objects;

public class Vehicle {
	
	private String type;
	private String brand;
	private String model;
	private Integer year;
	private String plate;
	private Integer renavam;
	
	public Vehicle() {
		
	}

	public Vehicle(String vehicle, String brand, String model, Integer year, String plate, Integer renavam) {
		super();
		this.type = vehicle;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.plate = plate;
		this.renavam = renavam;
	}

	public String getVehicle() {
		return type;
	}

	public void setVehicle(String vehicle) {
		this.type = vehicle;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Integer getRenavam() {
		return renavam;
	}

	public void setRenavam(Integer renavam) {
		this.renavam = renavam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(renavam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(renavam, other.renavam);
	}
}
