package com.ECommerce.converter;

import org.springframework.stereotype.Component;

import com.ECommerce.Dto.UserDto;
import com.ECommerce.model.User;

@Component
public class UserConverter implements GenericsConverter<User, UserDto> {

	@Override
	public UserDto entityToDto(User user) {
		// TODO Auto-generated method stub
		return UserDto.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.isActive(user.isActive())
				.build();
	}

	@Override
	public User dtoToEntity(UserDto userDto) {
		// TODO Auto-generated method stub
		return User.builder()
				.id(userDto.getId())
				.name(userDto.getName())
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.isActive(userDto.isActive())
				.build();
	}

}
