package com.thejoa703.dto; 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter  @NoArgsConstructor  @AllArgsConstructor
public class LoginRequest {
	
	@Email   @NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	private String provider;
}

//2) LoginRequest  < email, password , provider >