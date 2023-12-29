package com.gdn.indeniza.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_dpvat")
public class Dpvat extends Service{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String insuranceCompany;
	private String sinistro;
	
	@ManyToOne
	private Vehicle vehicle;

	public Dpvat () {
		
	}

	public Dpvat(String insuranceCompany, String sinistro, Long id, Double payment, Vehicle vehicle) {
		super(id, payment);
		this.insuranceCompany = insuranceCompany;
		this.sinistro = sinistro;
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getSinistro() {
		return sinistro;
	}

	public void setSinistro(String sinistro) {
		this.sinistro = sinistro;
	}
}
