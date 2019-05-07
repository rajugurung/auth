package com.svlada.security.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.svlada.entity.Role;
import com.svlada.entity.User;
import com.svlada.user.repository.UserRepository;

@RestController("api/auth/singup")
public class SignupController {
	private static final Integer ADMIN_ROLE_ID = 1;
	private BCryptPasswordEncoder pwdEncoder;
	private UserRepository userRepo;

	@Autowired
	public SignupController(BCryptPasswordEncoder pwdEncoder,UserRepository userRepo) {
		this.pwdEncoder = pwdEncoder;
		this.userRepo = userRepo;
	}

	@PostMapping
	public void signUp(@RequestBody User user) {
		String encodedPwd = pwdEncoder.encode(user.getPassword());
		
		Role role = new Role();
		role.setId(ADMIN_ROLE_ID);
		User userToSave = new User(encodedPwd, user.getUserName());
		userToSave.addRole(role);
		userRepo.save(userToSave);
	}
	
}
