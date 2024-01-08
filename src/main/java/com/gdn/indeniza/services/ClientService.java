package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Client;
import com.gdn.indeniza.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Client update(Long id, Client obj) {
		Client entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Client obj, Client entity) {
		entity.setAdress(obj.getAdress());
		entity.setBirth(obj.getBirth());
		entity.setCpf(obj.getCpf());
		entity.setEmail(obj.getEmail());
		entity.setHealthInsurance(obj.getHealthInsurance());
		entity.setMotherName(obj.getMotherName());
		entity.setName(obj.getName());
		entity.setPhone1(obj.getPhone1());
		entity.setPhone2(obj.getPhone2());
		entity.setRg(obj.getRg());
	}
}
