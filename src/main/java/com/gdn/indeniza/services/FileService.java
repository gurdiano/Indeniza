package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.File;
import com.gdn.indeniza.repositories.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository repository;
	
	public List<File> findAll(){
		return repository.findAll();
	}
	
	public File findById(Long id) {
		Optional<File> obj = repository.findById(id);
		return obj.get();
	}
	
	public File insert(File obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public File update(Long id, File obj) {
		File entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(File obj, File entity) {
		entity.setName(obj.getName());
		entity.setOrder(obj.getOrder());
		entity.setPath(obj.getPath());
	}
}
