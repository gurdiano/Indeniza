package com.gdn.indeniza.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_report")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate initialDate;
	private LocalDate finalDate;
	private User colab;
	
	public Report() {
		
	}

	public Report(Long id, LocalDate initialDate, LocalDate finalDate, User colab) {
		super();
		this.id = id;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.colab = colab;
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

//	public Double GenerateReport() {
//		return 1.2;
//	}
}
