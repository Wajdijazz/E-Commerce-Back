package com.ECommerce.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class EntityNotFoundException extends RuntimeException {
	private final HttpStatus errCode;
	private final String errMsg;


	
}
