package com.gdn.indeniza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.User;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public User authenticate(String login, String password) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(login, password);
		return (User)authenticationManager.authenticate(usernamePassword).getPrincipal();
	}
}
