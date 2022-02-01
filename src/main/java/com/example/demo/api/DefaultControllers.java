package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class DefaultControllers {

	@GetMapping
	public ResponseEntity<String> getHome(){
		return new ResponseEntity<>("Wellcome to home page 2", HttpStatus.OK);
	}
}
