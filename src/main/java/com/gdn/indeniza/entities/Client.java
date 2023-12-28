package com.gdn.indeniza.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name= "tb_client")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate birth;
	@Column(unique = true)
	@CPF
	private String cpf;
	private String rg;
	private String phone1;
	private String phone2;
	@Email
	private String email;
	private String motherName;
	
	@OneToMany(mappedBy = "client")
	private Set<Order> order = new HashSet<>();
	
	@ManyToOne
	private Hospital healthInsurance;
	
	@OneToOne
	private Address address;
	
	public Client() {
		
	}
	
	public Client(Long id, String name, LocalDate birth, String cpf, String rg, String phone1, 
			String phone2, String email, String motherName, Hospital healthInsurance, Address address) {
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.cpf = cpf;
		this.rg = rg;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.motherName = motherName;
		this.healthInsurance = healthInsurance;
		this.address = address;
	}
	
	public Address getAdress() {
		return address;
	}

	public void setAdress(Address adress) {
		this.address = adress;
	}

	public Hospital getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(Hospital healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf);
	}
}
