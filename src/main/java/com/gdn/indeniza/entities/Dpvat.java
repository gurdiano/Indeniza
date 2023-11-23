package com.gdn.indeniza.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_dpvat")
public class Dpvat extends Service{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private String sinistro;
	private String hospital;
	
	public Dpvat () {
		
	}

	public Dpvat(String name, String sinistro, String hospital, Long id, Double payment) {
		super(id, payment);
		this.name = name;
		this.sinistro = sinistro;
		this.hospital = hospital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinistro() {
		return sinistro;
	}

	public void setSinistro(String sinistro) {
		this.sinistro = sinistro;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
}
