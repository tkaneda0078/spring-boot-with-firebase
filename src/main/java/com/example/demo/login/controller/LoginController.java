package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.LoginForm;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String getLogin(@ModelAttribute LoginForm form, Model model) {
		return "login/login";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute LoginForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return getLogin(form, model);
		}

		return "login/login";
	}
}
