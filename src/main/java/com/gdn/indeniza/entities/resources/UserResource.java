package com.gdn.indeniza.entities.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdn.indeniza.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User teste = new User(1L, "Tiago", "sasaas@As05", "tiagofran2013@hotmail.com", new Date());
		return ResponseEntity.ok().body(teste);
	}

}
