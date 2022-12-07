package com.capstone.nationalparkvisits.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.capstone.nationalparkvisits.validation.UsernameUnique;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupForm {
	
	private Integer id;

	@NotEmpty(message = "firstname is required.")
	@Length(max = 255, message = "firstname must be less than 255 characters.")
	private String firstname;

	@NotEmpty(message = "lastname is required.")
	@Length(max = 255, message = "lastname must be less than 255 characters.")
	private String lastname;

	@Length(max = 65534, message = "Entry must be shorter than 65534 characters.")
	private String description;

	@NotEmpty(message = "Username is required.")
	@Length(max = 255, message = "Username must be less than 255 characters.")
	@UsernameUnique(message = "Username already exists in the database.")
	private String username;

	@Pattern(regexp = "^[a-zA-Z0-9!@#]+$", message = "Password can only contain lowercase, uppercase, and special caracters")
	@Length(min = 8, message = "Password must be longer than 8 characters.")
	@Length(max = 255, message = "Password must be shorter than 255 characters.")
	private String password;

	@NotEmpty(message = "Email is required.")
	private String email;
	
	@NotEmpty(message = "Confirm password is required.")
	private String confirmPassword;
}
