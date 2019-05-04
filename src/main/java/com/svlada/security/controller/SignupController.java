package com.svlada.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.svlada.entity.User;
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
//		role.id = new UserRole.Id(null, RoleEnum.ADMIN);
		
		User savedUser =  userRepo.save(new User(null, user.getUsername(), encodedPwd, null));
		System.out.println(savedUser);
	}
	
	private void createUser() {
		User user = new User();
		
	}
}
