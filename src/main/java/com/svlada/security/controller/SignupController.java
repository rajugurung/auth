package com.svlada.security.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.svlada.entity.Role;
import com.svlada.entity.User;
import com.svlada.entity.UserRole;
import com.svlada.user.repository.UserRepository;

@RestController("api/auth/singup")
public class SignupController {
	
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
//		Role role = new Role();
//		role.setId(1);
//		role.setName("ADMIN");
//		UserRole userRole = new UserRole();
//		userRole.setRoleId(1);
//		user.addUserRole(userRole);
//		User userToSave = new User(encodedPwd, user.getUserName(), Arrays.asList(userRole));
		
		Role role = new Role();
		role.setName("ADMIN");
		role.setId(1);
		User userToSave = new User(encodedPwd, user.getUserName(), null);
		userToSave.setRoles(new HashSet<>(Arrays.asList(role)));
		User savedUser =  userRepo.save(userToSave);
		System.out.println(savedUser.toString());
	}
	
}
