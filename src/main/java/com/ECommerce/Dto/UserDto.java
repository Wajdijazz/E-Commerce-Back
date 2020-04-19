package com.ECommerce.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class UserDto {

	private Long id;

	private String email;

	private String password;

	private String confirmedPassword;

	private String name;

	private boolean isActive;

}
