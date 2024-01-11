package com.gdn.indeniza.dtos;

import java.time.LocalDate;

import com.gdn.indeniza.entities.User;

public record ReportDTO (LocalDate initialDate, LocalDate finalDate, User colab){
	
}
