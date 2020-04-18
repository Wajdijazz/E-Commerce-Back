package com.ECommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	public UserDto saveUser(@RequestBody UserDto userDto) {
		return userConverter.entityToDto(userService.saveUser(userDto));
	}
	
	@GetMapping("/")
	public List<UserDto> getUsers(@RequestBody UserDto userDto) {
		return userConverter.entityListToDtoList(userService.getAllUsers());
	}

}
