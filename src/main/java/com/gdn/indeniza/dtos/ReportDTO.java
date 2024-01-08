package com.gdn.indeniza.dtos;

import java.time.LocalDate;

import com.gdn.indeniza.entities.User;

public class ReportDTO {
	
	private LocalDate initialDate;
	private LocalDate finalDate;
	private User colab;

	public ReportDTO() {
		
	}

	public ReportDTO(LocalDate initialDate, LocalDate finalDate, User colab) {
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.colab = colab;
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
}
