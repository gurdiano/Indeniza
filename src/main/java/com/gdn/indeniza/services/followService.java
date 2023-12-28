package com.gdn.indeniza.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Follow;
import com.gdn.indeniza.entities.Order;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.entities.enums.Status;
import com.gdn.indeniza.repositories.FollowRepository;
import com.gdn.indeniza.repositories.OrderRepository;

@Service
public class followService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private FollowRepository followRepository;
	
	public Follow CreateFollow(String registry, Status status, Order order, User user) {
		Follow follow = new Follow(null, LocalDateTime.now(), registry, status, order, user);
		order.getFollow().add(follow);
		followRepository.save(follow);
		orderRepository.save(order);
		return follow;
	}
}
