package com.example.demo.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
	@GetMapping("/list")
	public String index(Model model) {
		return "list/index";
	}
}
