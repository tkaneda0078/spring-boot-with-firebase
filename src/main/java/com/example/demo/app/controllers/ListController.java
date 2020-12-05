package com.example.demo.app.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.services.UserService;

@Controller
public class ListController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String index(Model model) throws InterruptedException, ExecutionException {
		System.out.println(userService.getAll());
		return "list/index";
	}
}
