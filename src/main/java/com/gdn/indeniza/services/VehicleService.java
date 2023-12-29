package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Vehicle;
import com.gdn.indeniza.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	public List<Vehicle> findAll(){
		return repository.findAll();
	}
	
	public Vehicle findById(Long id) {
		Optional<Vehicle> obj = repository.findById(id);
		return obj.get();
	}
	
	public Vehicle insert(Vehicle obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Vehicle update(Long id, Vehicle obj) {
		Vehicle entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Vehicle obj, Vehicle entity) {
		entity.setBrand(obj.getBrand());
		entity.setManufacture(obj.getManufacture());
		entity.setModel(obj.getModel());
		entity.setPlate(obj.getPlate());
		entity.setRenavam(obj.getRenavam());
		entity.setType(obj.getType());
	}
}
