package com.gdn.indeniza.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_vehicle")
public class Vehicle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String brand;
	private String model;
	private Integer manufacture;
	private String plate;
	@Column(unique = true)
	private String renavam;
	
	@OneToMany(mappedBy = "vehicle")
	private Set<Dpvat> dpvat = new HashSet<>();
	
	public Vehicle() {
		
	}

	public Vehicle(Long id, String type, String brand, String model, Integer manufacture, String plate, String renavam) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.manufacture = manufacture;
		this.plate = plate;
		this.renavam = renavam;
	}
	
	public Set<Dpvat> getDpvat() {
		return dpvat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Integer getManufacture() {
		return manufacture;
	}

	public void setManufacture(Integer manufacture) {
		this.manufacture = manufacture;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
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
