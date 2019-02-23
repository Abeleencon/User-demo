package com.codewarrior.userdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewarrior.userdemo.service.RestClientService;

@Controller
public class HomeController {

	private static final String appName = "Users Display";
	private final RestClientService service;

	@Autowired
	public HomeController(RestClientService service){
		this.service = service;
	}

	@GetMapping("/")
	public String home(Model model,
			@RequestParam(value = "name", required = false,
			defaultValue = "Guest") String name) {

		model.addAttribute("name", name);
		model.addAttribute("title", appName);
		return "home";
	}

	@GetMapping("users")
	public String getAll(Model model){
		model.addAttribute("users", service.GetAllUsers());
		return "users";
	}
}