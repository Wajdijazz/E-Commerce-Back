package com.ECommerce.service;

import javax.transaction.Transactional;

import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ECommerce.Dto.UserDto;
import com.ECommerce.converter.UserConverter;
import com.ECommerce.dao.UserRepository;
import com.ECommerce.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class UserServiceImpl {

	private UserRepository userRepository;
	private UserConverter userConverter;
	private PasswordEncoder passwordEncoder;

	public User saveUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(userConverter.dtoToEntity(userDto));
	}

}
