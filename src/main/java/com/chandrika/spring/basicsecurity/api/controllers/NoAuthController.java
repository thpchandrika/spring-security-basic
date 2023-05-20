package com.chandrika.spring.basicsecurity.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noAuth/rest")
public class NoAuthController {

	@GetMapping("/sayHi")
	public String sayHi() {
		return "Hi, No Spring security enabled";
	}

}
