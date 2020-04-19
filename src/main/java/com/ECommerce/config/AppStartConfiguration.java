package com.ECommerce.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ECommerce.model.Role;
import com.ECommerce.service.UserServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class AppStartConfiguration implements CommandLineRunner {

	private UserServiceImpl userService;

	@Override
	public void run(String... args) throws Exception {
		userService.saveRole(new Role(null, "USER", null));
		userService.saveRole(new Role(null, "ADMIN", null));
	}

}
