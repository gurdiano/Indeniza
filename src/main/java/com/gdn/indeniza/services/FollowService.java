package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Follow;
import com.gdn.indeniza.entities.Order;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.entities.enums.Status;
import com.gdn.indeniza.repositories.FollowRepository;
import com.gdn.indeniza.repositories.OrderRepository;

@Service
public class FollowService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private FollowRepository repository;
	
	public Follow CreateFollow(String registry, Status status, Order order, User user) {
		Follow follow = new Follow(null, registry, status, order, user);
		order.getFollow().add(follow);
		repository.save(follow);
		orderRepository.save(order);
		return follow;
	}
	
	public List<Follow> findAll(){
		return repository.findAll();
	}
	
	public Follow findById(Long id) {
		Optional<Follow> obj = repository.findById(id);
		return obj.get();
	}
	
	public Follow insert(Follow obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Follow update(Long id, Follow obj) {
		Follow entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Follow obj, Follow entity) {
		entity.setRegistry(obj.getRegistry());
		entity.setStatus(obj.getStatus());
	}
}
