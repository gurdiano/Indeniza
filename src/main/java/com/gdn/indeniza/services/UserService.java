package com.gdn.indeniza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.entities.enums.Role;
import com.gdn.indeniza.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByEmail(username);
	}
	
	public Boolean registerUser(String name, String login, String password, Role role) {
		if(loadUserByUsername(login) != null) return false;
		String encryptedPassword = new BCryptPasswordEncoder().encode(password);
		insert(new User(null, name, encryptedPassword, login, role));
		return true;
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(User obj, User entity) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPassword(obj.getPassword());
	}
}
