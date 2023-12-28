package com.gdn.indeniza.entities.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
//	@GetMapping
//	public ResponseEntity<User> findAll(){
//		User teste = new User(1L, "Tiago", "sasaas@As05", "tiagofran2013@hotmail.com", LocalDate.now());
//		return ResponseEntity.ok().body(teste);
//	}

}
