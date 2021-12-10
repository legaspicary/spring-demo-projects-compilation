package com.legaspicary.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@GetMapping("/")
	public String getServerTime() {
		return LocalDateTime.now().toString();
	}

	@GetMapping("/workout")
	public String getWorkout() {
		return "Push up 300 times and run 300KM";
	}

}
