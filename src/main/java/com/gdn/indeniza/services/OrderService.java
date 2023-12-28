package com.gdn.indeniza.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Client;
import com.gdn.indeniza.entities.Follow;
import com.gdn.indeniza.entities.Order;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.entities.enums.Status;
import com.gdn.indeniza.repositories.FollowRepository;
import com.gdn.indeniza.repositories.OrderRepository;
import com.gdn.indeniza.repositories.ServiceRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private FollowRepository followRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	@Transactional
	public Order createOrder(Client client, User partner, com.gdn.indeniza.entities.Service service, Status status) {
		Order order = new Order(null, status, LocalDate.now(), service, client, partner);
		service.setOrder(order);
		serviceRepository.save(service);
		orderRepository.save(order);
		
		Follow follow = new Follow(null, LocalDateTime.now(), "default", status, order, partner);
		followRepository.save(follow);

		return order;
	}
}
