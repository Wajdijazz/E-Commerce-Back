package com.ECommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ECommerce.Dto.UserDto;
import com.ECommerce.converter.UserConverter;
import com.ECommerce.dao.RoleRepository;
import com.ECommerce.dao.UserRepository;
import com.ECommerce.model.Role;
import com.ECommerce.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class UserServiceImpl {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public User saveUser(UserDto userDto) {
		User user = userRepository.findByEmail(userDto.getEmail());
		if (user != null)
			throw new RuntimeException("User already exists");
		if (!userDto.getPassword().equals(userDto.getConfirmedPassword()))
			throw new RuntimeException("Please confirm your password");
		User userSaved =User.builder()
							.email(userDto.getEmail())
							.name(userDto.getName())
							.password(userDto.getPassword())
							.isActive(true)
				            .build();
		userRepository.save(userSaved);
		addRoleToUser(userDto.getEmail(), "USER");
		return userSaved;
	}

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void addRoleToUser(String email, String rolename) {
		User appUser = userRepository.findByEmail(email);
		Role appRole = roleRepository.findByRoleName(rolename);
		appUser.getRoles().add(appRole);
		User user=userRepository.save(appUser);
		System.out.println(user);

		
	}
}
