package com.capstone.nationalparkvisits.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewEventForm {
	
	private Integer id;
	
	private Integer visitId;
	
	@NotEmpty(message = "Name is required.")
	private String name;
	
	@Length(max = 65534, message = "Entry must be shorter than 65534 characters.")
	private String description;

}
