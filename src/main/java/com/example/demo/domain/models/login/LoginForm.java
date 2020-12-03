package com.example.demo.domain.models.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {
	@NotBlank
	@Email
	private String userId;

	@NotBlank
	private String password;
}
