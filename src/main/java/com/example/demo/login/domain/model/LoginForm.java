package com.example.demo.login.domain.model;

import lombok.Data;

@Data
public class LoginForm {
	/*
	 * user ID
	 */
	private String userId;

	/**
	 * password
	 */
	private String password;
}
