package com.ECommerce.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ECommerce.Dto.UserDto;
import com.ECommerce.dao.RoleRepository;
import com.ECommerce.dao.UserRepository;
import com.ECommerce.exception.ResourceNotFoundException;
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
		if (userRepository.findByEmail(userDto.getEmail()) != null)
			throw new ResourceNotFoundException("User already exists");
		if (!userDto.getPassword().equals(userDto.getConfirmedPassword()))
			throw new ResourceNotFoundException("Please confirm your password");
		User userSaved = User.builder().email(userDto.getEmail()).name(userDto.getName())
				.password(passwordEncoder.encode(userDto.getPassword())).isActive(true).build();
		addRoleToUser(userSaved, "USER");
		return userRepository.save(userSaved);

	}

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void addRoleToUser(User user, String rolename) {
		Role appRole = roleRepository.findByRoleName(rolename);
		Set<Role> roles = new HashSet<>();
		roles.add(appRole);
		user.setRoles((roles));
	}
}
