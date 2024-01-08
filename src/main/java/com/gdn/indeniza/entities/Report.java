package com.gdn.indeniza.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name= "tb_report")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate initialDate;
	private LocalDate finalDate;
	private User colab;
	
	@Transient
	private List<Order> orders;
	
	public Report() {
		
	}

	public Report(Long id, LocalDate initialDate, LocalDate finalDate, User colab, List<Order> orders) {
		super();
		this.id = id;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.colab = colab;
		this.orders = orders;
	}

	public List<Order> getOrders(){
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public User getColab() {
		return colab;
	}

	public void setColab(User colab) {
		this.colab = colab;
	}

	public Double getGeneratedReport() {
		double sum = 0;
		for (Order order : orders) {
			sum += order.getService().getCommissionAmount();
		}
		return sum;
	}

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
		Report other = (Report) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
