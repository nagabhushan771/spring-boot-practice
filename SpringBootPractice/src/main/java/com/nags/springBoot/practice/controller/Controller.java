package com.nags.springBoot.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String helloWorld() {
		return "Hey Nags, How you doin???";
	}
}
