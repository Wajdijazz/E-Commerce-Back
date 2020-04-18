package com.ECommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.Dto.UserDto;
import com.ECommerce.converter.UserConverter;
import com.ECommerce.service.UserServiceImpl;
import com.ECommerce.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.USER)
public class UserController {

	private UserServiceImpl userService;
	private UserConverter userConverter;
	
	//I have also make a RestControlleradvice
	@PostMapping("/register")
	public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
		try {
			return ResponseEntity.ok(userConverter.entityToDto(userService.saveUser(userDto)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
