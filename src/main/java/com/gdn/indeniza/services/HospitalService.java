package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Hospital;
import com.gdn.indeniza.repositories.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	public List<Hospital> findAll(){
		return repository.findAll();
	}
	
	public Hospital findById(Long id) {
		Optional<Hospital> obj = repository.findById(id);
		return obj.get();
	}
	
	public Hospital insert(Hospital obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Hospital update(Long id, Hospital obj) {
		Hospital entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Hospital obj, Hospital entity) {
		entity.setName(obj.getName());
		entity.setAdress(obj.getAdress());
	}
}
