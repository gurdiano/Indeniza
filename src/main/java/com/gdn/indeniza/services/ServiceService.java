package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdn.indeniza.entities.Service;
import com.gdn.indeniza.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {

	@Autowired
	private ServiceRepository repository;
	
	public List<Service> findAll(){
		return repository.findAll();
	}
	
	public Service findById(Long id) {
		Optional<Service> obj = repository.findById(id);
		return obj.get();
	}
	
	public Service insert(Service obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Service update(Long id, Service obj) {
		Service entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Service obj, Service entity) {
		entity.setPayment(obj.getPayment());
	}
}
