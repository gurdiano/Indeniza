package com.gdn.indeniza.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdn.indeniza.dtos.AuthenticationDTO;
import com.gdn.indeniza.dtos.LoginResponseDTO;
import com.gdn.indeniza.dtos.RegisterDTO;
import com.gdn.indeniza.services.AuthService;
import com.gdn.indeniza.services.TokenService;
import com.gdn.indeniza.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationResource {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
		var token = tokenService.generateToken(authService.authenticate(data.login(), data.password()));
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
		if (userService.registerUser(data.name(), 
				data.login(), 
				data.password(), 
				data.role()
				)
			) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
