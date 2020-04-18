package com.ECommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ECommerce.Dto.UserDto;
import com.ECommerce.dao.UserRepository;
import com.ECommerce.model.Role;
import com.ECommerce.model.User;
import com.ECommerce.service.UserServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class AppStartConfiguration implements CommandLineRunner {

	private UserServiceImpl userService;
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userService.saveRole(new Role(null, "USER"));
		userService.saveRole(new Role(null, "ADMIN"));
		userRepository.save(new User(null,"admin@gmail.com" , "admin","admin",true,null));
	}

}
