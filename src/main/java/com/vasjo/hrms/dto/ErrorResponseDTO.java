package com.vasjo.hrms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {
	
	private String error;
	private String code;

	public ErrorResponseDTO() {
		
	}
	
	public ErrorResponseDTO(String error, String code) {
		this.error = error;
		this.code = code; 
	}

}
