package com.gdn.indeniza.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.indeniza.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	Optional<Order> findByDate(LocalDate date);
	List<Order> findByDateBetween(LocalDate initialDate, LocalDate finalDate);
}
