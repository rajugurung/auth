package com.svlada.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/auth/singup")
public class SignupController {

	@PostMapping
	public void signUp() {
		System.out.println("hi");
	}
}
