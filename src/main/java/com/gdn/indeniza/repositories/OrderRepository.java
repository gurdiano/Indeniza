package com.gdn.indeniza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.indeniza.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
