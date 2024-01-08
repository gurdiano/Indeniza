package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Address;
import com.gdn.indeniza.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll(){
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.get();
	}
	
	public Address insert(Address obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Address update(Long id, Address obj) {
		Address entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Address obj, Address entity) {
		entity.setCep(obj.getCep());
		entity.setCity(obj.getCity());
		entity.setDistrict(obj.getDistrict());
		entity.setHouseNumber(obj.getHouseNumber());
		entity.setState(obj.getState());
		entity.setStreet(obj.getStreet());
	}
}
