package com.gdn.indeniza.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdn.indeniza.dtos.AuthenticationDTO;
import com.gdn.indeniza.dtos.LoginResponseDTO;
import com.gdn.indeniza.dtos.RegisterDTO;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.repositories.UserRepository;
import com.gdn.indeniza.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((User)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		
		if(userRepository.findByEmail(data.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		
		//tirar dps
		//public User(Long id, String name, String password, String email, Role role)
		User user = new User(null, "teste", encryptedPassword, data.login(), data.role());
		
		userRepository.save(user);
		
		return ResponseEntity.ok().build();
	}
}
