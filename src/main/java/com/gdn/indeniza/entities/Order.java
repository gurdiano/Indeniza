package com.gdn.indeniza.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdn.indeniza.entities.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_order")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Status status;
	private LocalDate date;
	
	@OneToOne
	@MapsId
	private Service service;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private User partner;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private Set<File> file = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<Follow> follow = new ArrayList<>();
	
	//constructors
	public Order() {
		
	}

	public Order(Long id, Status status, LocalDate date, Service service, Client client, User partner) {
		this.id = id;
		this.status = status;
		this.date = date;
		this.service = service;
		this.client = client;
		this.partner = partner;
	}
	
	// getters e setters 
	public List<Follow> getFollow() {
		return follow;
	}
	
	public Set<File> getFile() {
		return file;
	}
	
	public User getPartner() {
		return partner;
	}


	public void setPartner(User partner) {
		this.partner = partner;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	//hash and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
