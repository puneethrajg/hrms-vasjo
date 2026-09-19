package com.vasjo.hrms.dto;

public class ErrorResponseDTO {
	
	private String error;
	private String code;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ErrorResponseDTO() {
		
	}
	
	public ErrorResponseDTO(String error, String code) {
		this.error = error;
		this.code = code; 
	}

}
