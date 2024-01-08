package com.gdn.indeniza.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
	private OrderRepository repository;
	@Autowired
	private FollowRepository followRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	@Transactional
	public Order createOrder(Client client, User partner, com.gdn.indeniza.entities.Service service, Status status) {
		Order order = new Order(null, status, LocalDate.now(), service, client, partner);
		service.setOrder(order);
		serviceRepository.save(service);
		repository.save(order);
		
		Follow follow = new Follow(null, "default", status, order, partner);
		followRepository.save(follow);

		return order;
	}
	
	public List<Order> getSeason(LocalDate initialDate, LocalDate finalDate){
		return repository.findByDateBetween(initialDate, finalDate);
	}
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Order update(Long id, Order obj) {
		Order entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Order obj, Order entity) {
		entity.setStatus(obj.getStatus());
	}
}
